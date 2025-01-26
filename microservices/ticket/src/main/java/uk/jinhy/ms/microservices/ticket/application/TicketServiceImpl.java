package uk.jinhy.ms.microservices.ticket.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.jinhy.ms.api.core.ticket.application.TicketService;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;
import uk.jinhy.ms.microservices.ticket.common.ErrorCode;
import uk.jinhy.ms.microservices.ticket.domain.TicketEntity;
import uk.jinhy.ms.microservices.ticket.domain.TicketEntityMapper;
import uk.jinhy.ms.microservices.ticket.domain.TicketRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketEntityMapper ticketEntityMapper;

    @Override
    public Ticket getTicketByName(String name) {
        TicketEntity ticketEntity = ticketRepository.findByName(name).orElseThrow(ErrorCode.TICKET_NOT_FOUND::throwException);
        return ticketEntityMapper.entityToTicket(ticketEntity);
    }

    @Override
    public Ticket getTicketByUuid(String uuid) {
        TicketEntity ticketEntity = ticketRepository.findByUuid(uuid).orElseThrow(ErrorCode.TICKET_NOT_FOUND::throwException);
        return ticketEntityMapper.entityToTicket(ticketEntity);
    }
}
