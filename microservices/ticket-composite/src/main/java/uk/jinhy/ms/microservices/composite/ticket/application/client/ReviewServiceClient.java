package uk.jinhy.ms.microservices.composite.ticket.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.review.presentation.dto.CreateReviewRequestDto;

import java.util.List;

@FeignClient(name = "REVIEW-SERVICE", url = "${spring.microservices.review.url}")
public interface ReviewServiceClient {
    @GetMapping("/ticket/{ticketId}")
    List<Review> getReviewByTicketId(@PathVariable("ticketId") int ticketId);

    @PostMapping("")
    Review createReview(CreateReviewRequestDto body);

    @DeleteMapping("/{uuid}")
    void deleteReview(@PathVariable("uuid") String uuid);
}
