package uk.jinhy.ms.api.composite.ticket.presentation.dto;

import lombok.Data;

import java.util.List;

@Data
public class TicketResponseDto {
    private final String id;
    private final String name;
    private final List<ReviewDto> reviews;

    @Data
    public static class ReviewDto {
        private final String id;
        private final String content;
        private final String username;
    }
}
