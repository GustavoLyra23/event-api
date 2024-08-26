package com.lyra.event.dto.user;

import com.lyra.event.dto.event.EventDto;
import com.lyra.event.entities.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Getter
public class UserDto {

    private Long id;
    private String username;
    private List<EventDto> events = new ArrayList<>();
    private List<EventDto> eventsJoined = new ArrayList<>();
    private String profilePicture;
    private String description;

    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        username = user.getUsername();
        user.getEvents().forEach(event -> eventsJoined.add(new EventDto(event)));
        user.getEventsJoined().forEach(event -> eventsJoined.add(new EventDto(event)));
        if (user.getProfilePicture() != null) {
            profilePicture = Base64.getEncoder().encodeToString(user.getProfilePicture());
        }
        description = user.getDescription();
    }


}
