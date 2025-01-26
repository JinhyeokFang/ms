package uk.jinhy.ms.api.core.review.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Review {
    private int id;
    private String uuid;
    private int ticketId;
    private int userId;
    private String content;
}
