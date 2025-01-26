package uk.jinhy.ms.api.core.ticket.application;

import uk.jinhy.ms.api.core.ticket.domain.Ticket;

public interface TicketService {
    Ticket getTicketByName(String name);
    Ticket  getTicketByUuid(String uuid);
}
