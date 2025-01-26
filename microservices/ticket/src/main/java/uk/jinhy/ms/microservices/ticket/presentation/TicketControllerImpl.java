package uk.jinhy.ms.microservices.ticket.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.ms.api.core.ticket.application.TicketService;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;
import uk.jinhy.ms.api.core.ticket.presentation.TicketController;
import uk.jinhy.ms.microservices.ticket.common.ErrorCode;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TicketControllerImpl implements TicketController {
    private final TicketService ticketService;

    @Override
    public Ticket getTicket(String name, String uuid) {
        log.info(name);
        log.info(uuid);
        if (name != null) {
            return ticketService.getTicketByUuid(name);
        }

        if (uuid != null) {
            return ticketService.getTicketByUuid(uuid);
        }

        throw ErrorCode.BAD_PARAMETER_CONDITION.throwException();
    }
}
