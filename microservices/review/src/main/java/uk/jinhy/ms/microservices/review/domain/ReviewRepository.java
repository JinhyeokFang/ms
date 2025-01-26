package uk.jinhy.ms.microservices.review.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<ReviewEntity, Integer> {
    Optional<ReviewEntity> findByUuid(String uuid);
    List<ReviewEntity> findByTicketId(int ticketId);
    void deleteById(int id);
}
