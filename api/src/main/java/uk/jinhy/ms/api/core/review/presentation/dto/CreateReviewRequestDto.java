package uk.jinhy.ms.api.core.review.presentation.dto;

import lombok.Data;

@Data
public class CreateReviewRequestDto {
    private final int ticketId;
    private final int userId;
    private final String content;
}
