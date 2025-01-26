package uk.jinhy.ms.microservices.ticket.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
    Optional<TicketEntity> findByUuid(String uuid);
    Optional<TicketEntity> findByName(String name);
}
