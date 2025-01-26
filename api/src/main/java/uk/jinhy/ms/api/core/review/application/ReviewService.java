package uk.jinhy.ms.api.core.review.application;

import uk.jinhy.ms.api.core.review.application.dto.SaveReviewDto;
import uk.jinhy.ms.api.core.review.domain.Review;

import java.util.List;

public interface ReviewService {
    Review getReviewByUuid(String uuid);
    List<Review> getReviewsByTicketId(int ticketId);
    void saveReview(SaveReviewDto dto);
    void deleteReview(int id);
}
