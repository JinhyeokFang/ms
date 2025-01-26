package uk.jinhy.ms.microservices.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.jinhy.ms.api.core.user.application.UserService;
import uk.jinhy.ms.api.core.user.domain.User;
import uk.jinhy.ms.microservices.user.common.ErrorCode;
import uk.jinhy.ms.microservices.user.domain.UserEntity;
import uk.jinhy.ms.microservices.user.domain.UserEntityMapper;
import uk.jinhy.ms.microservices.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User getUserById(int id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(ErrorCode.USER_NOT_FOUND::throwException);
        return userEntityMapper.entityToUser(userEntity);
    }

    @Override
    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(ErrorCode.USER_NOT_FOUND::throwException);
        return userEntityMapper.entityToUser(userEntity);
    }
}
