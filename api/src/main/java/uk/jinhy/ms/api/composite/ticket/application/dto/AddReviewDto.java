package uk.jinhy.ms.api.composite.ticket.application.dto;

import lombok.Data;

@Data
public class AddReviewDto {
    private final String ticketUuid;
    private final String content;
    private final String username;
}
