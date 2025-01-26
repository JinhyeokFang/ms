package uk.jinhy.ms.microservices.review.application;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.jinhy.ms.api.core.review.application.ReviewService;
import uk.jinhy.ms.api.core.review.application.dto.ReviewEvent;
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
        ReviewEntity reviewEntity = reviewRepository.findByUuid(uuid)
                .orElseThrow(ErrorCode.REVIEW_NOT_FOUND::throwException);
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

    @Transactional
    @KafkaListener(topics = "reviews", groupId = "review-group")
    public void processReviewEvent(ReviewEvent event) {
        switch (event.getType()) {
            case CREATE -> handleCreateReview(event);
            case DELETE -> handleDeleteReview(event);
        }
    }

    @Transactional
    public void handleCreateReview(ReviewEvent event) {
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .userId(event.getUserId())
                .ticketId(event.getTicketId())
                .content(event.getContent())
                .build();
        reviewRepository.save(reviewEntity);
    }

    @Transactional
    public void handleDeleteReview(ReviewEvent event) {
        ReviewEntity review = reviewRepository.findByUuid(event.getReviewId())
                .orElseThrow(ErrorCode.REVIEW_NOT_FOUND::throwException);
        reviewRepository.delete(review);
    }
}
