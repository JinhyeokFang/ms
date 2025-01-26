package uk.jinhy.ms.microservices.review.presentation;

import org.mapstruct.Mapper;
import uk.jinhy.ms.api.core.review.application.dto.SaveReviewDto;
import uk.jinhy.ms.api.core.review.presentation.dto.CreateReviewRequestDto;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ReviewControllerMapper {
    SaveReviewDto saveReviewDtoToCreateReviewRequestDto(CreateReviewRequestDto createReviewRequestDto);
}
