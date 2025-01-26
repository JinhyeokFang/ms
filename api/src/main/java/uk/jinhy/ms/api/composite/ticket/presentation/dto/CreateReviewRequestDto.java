package uk.jinhy.ms.api.composite.ticket.presentation.dto;

import lombok.Data;

@Data
public class CreateReviewRequestDto {
    private final String ticketUuid;
    private final String content;
    private final String username;
}
