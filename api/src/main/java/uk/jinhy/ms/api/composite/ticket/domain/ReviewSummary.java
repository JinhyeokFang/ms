package uk.jinhy.ms.api.composite.ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReviewSummary {
    private int id;
    private String uuid;
    private String content;
    private UserSummary user;
}
