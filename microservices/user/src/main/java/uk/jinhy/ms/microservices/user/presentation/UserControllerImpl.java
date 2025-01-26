package uk.jinhy.ms.microservices.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.ms.api.core.user.application.UserService;
import uk.jinhy.ms.api.core.user.domain.User;
import uk.jinhy.ms.api.core.user.presentation.UserController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public User getUser(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return userService.getUserById(id);
    }
}
