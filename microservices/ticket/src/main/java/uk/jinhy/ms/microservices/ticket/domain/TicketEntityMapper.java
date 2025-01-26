package uk.jinhy.ms.microservices.ticket.domain;

import org.mapstruct.Mapper;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TicketEntityMapper {
    TicketEntity ticketToEntity(Ticket ticket);
    Ticket entityToTicket(TicketEntity ticketEntity);
}
