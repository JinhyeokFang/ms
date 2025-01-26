package uk.jinhy.ms.api.core.review.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEvent {
    private Type type;
    private String reviewId;
    private int userId;
    private int ticketId;
    private String content;

    public enum Type {
        CREATE,
        DELETE
    }
}
