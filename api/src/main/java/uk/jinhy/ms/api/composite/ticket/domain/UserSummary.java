package uk.jinhy.ms.api.composite.ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserSummary {
    private int id;
    private String username;
}
