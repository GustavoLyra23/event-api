package com.lyra.event.dto.user;

import com.lyra.event.entities.User;
import lombok.Getter;

@Getter
public class UserDto {

    private Long id;
    private String username;

    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        username = user.getUsername();
    }


}
