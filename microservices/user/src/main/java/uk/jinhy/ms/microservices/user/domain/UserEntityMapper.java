package uk.jinhy.ms.microservices.user.domain;

import org.mapstruct.Mapper;
import uk.jinhy.ms.api.core.user.domain.User;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserEntityMapper {
    UserEntity userToEntity(User user);
    User entityToUser(UserEntity userEntity);
}
