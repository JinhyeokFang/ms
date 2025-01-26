package uk.jinhy.ms.api.composite.ticket.application;

import uk.jinhy.ms.api.composite.ticket.domain.TicketAggregate;
import uk.jinhy.ms.api.composite.ticket.application.dto.AddReviewDto;

public interface TicketCompositeService {
    TicketAggregate getTicketByUuid(String uuid);
    void addReview(AddReviewDto dto);
    void deleteReviewByReviewUuid(String reviewUuid);
}
