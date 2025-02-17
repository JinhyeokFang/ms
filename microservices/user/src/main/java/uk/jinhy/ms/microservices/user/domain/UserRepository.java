package uk.jinhy.ms.microservices.user.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findById(int id);
    Optional<UserEntity> findByUsername(String username);
}
