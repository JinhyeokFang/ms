package uk.jinhy.ms.microservices.composite.ticket.presentation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uk.jinhy.ms.api.composite.ticket.application.dto.AddReviewDto;
import uk.jinhy.ms.api.composite.ticket.domain.ReviewSummary;
import uk.jinhy.ms.api.composite.ticket.domain.TicketAggregate;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.CreateReviewRequestDto;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.TicketResponseDto;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface TicketCompositeControllerMapper {
    @Mappings({
            @Mapping(source = "uuid", target = "id"),
            @Mapping(target = "reviews", source = "reviews")
    })
    TicketResponseDto aggregateToResponseDto(TicketAggregate aggregate);
    @Mappings({
            @Mapping(source = "user.username", target = "username")
    })
    TicketResponseDto.ReviewDto reviewSummaryToReviewDto(ReviewSummary review);
    AddReviewDto createReviewRequestDtoToAddReviewDto(CreateReviewRequestDto requestDto);
}
