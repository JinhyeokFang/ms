package uk.jinhy.ms.microservices.composite.ticket.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.ms.api.composite.ticket.application.TicketCompositeService;
import uk.jinhy.ms.api.composite.ticket.application.dto.AddReviewDto;
import uk.jinhy.ms.api.composite.ticket.domain.TicketAggregate;
import uk.jinhy.ms.api.composite.ticket.presentation.TicketCompositeController;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.CreateReviewRequestDto;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.TicketResponseDto;

@RestController
@RequiredArgsConstructor
public class TicketCompositeControllerImpl implements TicketCompositeController {
    private final TicketCompositeService ticketCompositeService;
    private final TicketCompositeControllerMapper ticketCompositeControllerMapper;

    @Override
    public TicketResponseDto getTicketByUuid(String uuid) {
        TicketAggregate ticketAggregate = ticketCompositeService.getTicketByUuid(uuid);
        return ticketCompositeControllerMapper.aggregateToResponseDto(ticketAggregate);
    }

    @Override
    public void createReview(CreateReviewRequestDto dto) {
        AddReviewDto addReviewDto = ticketCompositeControllerMapper.createReviewRequestDtoToAddReviewDto(dto);
        ticketCompositeService.addReview(addReviewDto);
    }

    @Override
    public void deleteReview(String reviewUuid) {
        ticketCompositeService.deleteReviewByReviewUuid(reviewUuid);
    }
}
