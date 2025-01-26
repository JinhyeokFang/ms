package uk.jinhy.ms.microservices.review.domain;

import org.mapstruct.Mapper;
import uk.jinhy.ms.api.core.review.domain.Review;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ReviewEntityMapper {
    ReviewEntity reviewToEntity(Review review);
    Review entityToReview(ReviewEntity reviewEntity);
}
