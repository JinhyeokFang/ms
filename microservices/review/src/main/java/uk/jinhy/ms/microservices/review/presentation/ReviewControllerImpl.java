package uk.jinhy.ms.microservices.review.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.ms.api.core.review.application.ReviewService;
import uk.jinhy.ms.api.core.review.application.dto.SaveReviewDto;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.review.presentation.ReviewController;
import uk.jinhy.ms.api.core.review.presentation.dto.CreateReviewRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;
    private final ReviewControllerMapper reviewControllerMapper;

    @Override
    public List<Review> getReview(int ticketId) {
        return reviewService.getReviewsByTicketId(ticketId);
    }

    @Override
    public Review getReviewByUuid(String uuid) {
        return reviewService.getReviewByUuid(uuid);
    }

    @Override
    public void createReview(CreateReviewRequestDto requestDto) {
        SaveReviewDto dto = reviewControllerMapper.saveReviewDtoToCreateReviewRequestDto(requestDto);
        reviewService.saveReview(dto);
    }

    @Override
    public void deleteReviewById(int id) {
        reviewService.deleteReview(id);
    }
}
