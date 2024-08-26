package com.lyra.event.dto.event;

import com.lyra.event.entities.Event;
import lombok.Getter;

@Getter
public class EventDto {

    private Long id;
    private String name;

    public EventDto() {
    }


    public EventDto(Event event) {
        id = event.getId();
        name = event.getName();
    }


}
