package uk.jinhy.ms.microservices.review.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.jinhy.ms.api.core.review.application.ReviewService;
import uk.jinhy.ms.api.core.review.application.dto.SaveReviewDto;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.microservices.review.common.ErrorCode;
import uk.jinhy.ms.microservices.review.domain.ReviewEntity;
import uk.jinhy.ms.microservices.review.domain.ReviewEntityMapper;
import uk.jinhy.ms.microservices.review.domain.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Override
    public Review getReviewByUuid(String uuid) {
        ReviewEntity reviewEntity = reviewRepository.findByUuid(uuid).orElseThrow(ErrorCode.REVIEW_NOT_FOUND::throwException);
        return reviewEntityMapper.entityToReview(reviewEntity);
    }

    @Override
    public List<Review> getReviewsByTicketId(int ticketId) {
        List<ReviewEntity> reviewEntities = reviewRepository.findByTicketId(ticketId);
        return reviewEntities
                .stream()
                .map(reviewEntityMapper::entityToReview)
                .toList();
    }

    @Override
    @Transactional
    public void saveReview(SaveReviewDto dto) {
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .userId(dto.getUserId())
                .ticketId(dto.getTicketId())
                .content(dto.getContent())
                .build();
        reviewRepository.save(reviewEntity);
    }

    @Override
    @Transactional
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}
