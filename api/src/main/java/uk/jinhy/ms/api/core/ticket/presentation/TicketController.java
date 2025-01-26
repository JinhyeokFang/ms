package uk.jinhy.ms.api.core.ticket.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;

@RequestMapping(
        value = "/ticket",
        produces = "application/json")
public interface TicketController {
    @GetMapping("")
    Ticket getTicket(@RequestParam("name") String name, @RequestParam("uuid") String uuid);
}
