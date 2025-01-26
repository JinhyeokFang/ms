package uk.jinhy.ms.microservices.composite.ticket.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import uk.jinhy.ms.api.core.user.domain.User;

@FeignClient(name = "USER-SERVICE", url = "http://user-service")
public interface UserServiceClient {
    @GetMapping("")
    User getUserByUsername(@RequestParam("username") String username);

    @GetMapping("/{id}")
    User getUser(@PathVariable("id") int id);
}
