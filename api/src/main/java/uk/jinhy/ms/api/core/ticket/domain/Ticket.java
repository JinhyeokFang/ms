package uk.jinhy.ms.api.core.ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Ticket {
    private int id;
    private String uuid;
    private String name;
}
