package uk.jinhy.ms.api.core.user.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.jinhy.ms.api.core.user.domain.User;

@RequestMapping(
        value = "/user",
        produces = "application/json")
public interface UserController {
    @GetMapping("")
    User getUser(@RequestParam("username") String username);

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") int id);
}
