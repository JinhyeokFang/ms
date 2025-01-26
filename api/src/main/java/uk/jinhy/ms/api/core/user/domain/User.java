package uk.jinhy.ms.api.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String email;
}
