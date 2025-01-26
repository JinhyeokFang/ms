package uk.jinhy.ms.microservices.composite.ticket.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.jinhy.ms.api.core.ticket.domain.Ticket;

@FeignClient(name = "TICKET-SERVICE", url = "http://ticket-service")
public interface TicketServiceClient {
    @GetMapping("")
    Ticket getTicket(@RequestParam("name") String name, @RequestParam("uuid") String uuid);
}
