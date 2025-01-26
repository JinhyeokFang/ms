package uk.jinhy.ms.microservices.review.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.ms.api.core.review.application.ReviewService;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.review.presentation.ReviewController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;

    @Override
    public List<Review> getReview(int ticketId) {
        return reviewService.getReviewsByTicketId(ticketId);
    }

    @Override
    public Review getReviewByUuid(String uuid) {
        return reviewService.getReviewByUuid(uuid);
    }
}
