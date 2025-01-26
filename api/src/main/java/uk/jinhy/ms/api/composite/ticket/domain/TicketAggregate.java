package uk.jinhy.ms.api.composite.ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class TicketAggregate {
    private int id;
    private String uuid;
    private String name;
    private List<ReviewSummary> reviews;
}
