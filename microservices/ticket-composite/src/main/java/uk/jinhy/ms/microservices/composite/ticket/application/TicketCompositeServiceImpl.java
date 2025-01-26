package uk.jinhy.ms.microservices.composite.ticket.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import uk.jinhy.ms.api.composite.ticket.application.TicketCompositeService;
import uk.jinhy.ms.api.composite.ticket.application.dto.AddReviewDto;
import uk.jinhy.ms.api.composite.ticket.domain.ReviewSummary;
import uk.jinhy.ms.api.composite.ticket.domain.TicketAggregate;
import uk.jinhy.ms.api.core.review.application.dto.ReviewEvent;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;
import uk.jinhy.ms.api.core.user.domain.User;
import uk.jinhy.ms.microservices.composite.ticket.application.client.ReviewServiceClient;
import uk.jinhy.ms.microservices.composite.ticket.application.client.TicketServiceClient;
import uk.jinhy.ms.microservices.composite.ticket.application.client.UserServiceClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketCompositeServiceImpl implements TicketCompositeService {
    private final TicketServiceClient ticketServiceClient;
    private final ReviewServiceClient reviewServiceClient;
    private final UserServiceClient userServiceClient;
    private final TicketCompositeServiceMapper ticketCompositeServiceMapper;
    private final KafkaTemplate<String, ReviewEvent> kafkaTemplate;

    private static final String TOPIC = "reviews";

    @Override
    public TicketAggregate getTicketByUuid(String uuid) {
        Ticket ticket = ticketServiceClient.getTicket(null, uuid);
        List<Review> reviews = reviewServiceClient.getReviewByTicketId(ticket.getId());
        List<ReviewSummary> reviewSummaries = reviews.stream().map(review -> {
            User user = userServiceClient.getUser(review.getUserId());
            return ticketCompositeServiceMapper.reviewAndUserToSummary(review, user);
        }).toList();
        return TicketAggregate.builder()
                .id(ticket.getId())
                .uuid(ticket.getUuid())
                .name(ticket.getName())
                .reviews(reviewSummaries)
                .build();
    }

    @Override
    public void addReview(AddReviewDto dto) {
        log.info(dto.getUsername());
        User user = userServiceClient.getUserByUsername(dto.getUsername());
        Ticket ticket = ticketServiceClient.getTicket(null, dto.getTicketUuid());

        ReviewEvent event = new ReviewEvent(
                ReviewEvent.Type.CREATE,
                "",
                user.getId(),
                ticket.getId(),
                dto.getContent()
        );
        kafkaTemplate.send(TOPIC, event);
    }

    @Override
    public void deleteReviewByReviewUuid(String reviewUuid) {
        ReviewEvent event = new ReviewEvent(
                ReviewEvent.Type.DELETE,
                reviewUuid,
                0,
                0,
                ""
        );
        kafkaTemplate.send(TOPIC, event);
    }
}