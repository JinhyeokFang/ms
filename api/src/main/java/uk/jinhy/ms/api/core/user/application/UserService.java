package uk.jinhy.ms.api.core.user.application;

import uk.jinhy.ms.api.core.user.domain.User;

public interface UserService {
    User getUserById(int id);
    User getUserByUsername(String username);
}
