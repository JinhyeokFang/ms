package uk.jinhy.ms.api.core.review.application.dto;

import lombok.Data;

@Data
public class SaveReviewDto {
    private final int ticketId;
    private final int userId;
    private final String content;
}
