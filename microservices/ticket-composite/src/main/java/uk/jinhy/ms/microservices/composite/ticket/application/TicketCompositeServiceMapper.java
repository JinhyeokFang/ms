package uk.jinhy.ms.microservices.composite.ticket.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uk.jinhy.ms.api.composite.ticket.application.dto.AddReviewDto;
import uk.jinhy.ms.api.composite.ticket.domain.ReviewSummary;
import uk.jinhy.ms.api.composite.ticket.domain.UserSummary;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.review.presentation.dto.CreateReviewRequestDto;
import uk.jinhy.ms.api.core.user.domain.User;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface TicketCompositeServiceMapper {
    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "review.id", target = "id")
    })
    ReviewSummary reviewAndUserToSummary(Review review, User user);
    UserSummary userToUserSummary(User user);
    @Mappings({
            @Mapping(source = "ticketId", target = "ticketId"),
            @Mapping(source = "userId", target = "userId")
    })
    CreateReviewRequestDto addReviewDtoToCreateReviewRequestDto(AddReviewDto addReviewDto, int ticketId, int userId);
}
