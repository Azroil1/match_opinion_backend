package ru.amirmanyanov.matchopinion.mapping;

import ru.amirmanyanov.matchopinion.models.dto.ActorDto;
import ru.amirmanyanov.matchopinion.models.entity.Actor;

public class ActorMappers {
    public static ActorDto toDto(Actor actor) {
        return new ActorDto(actor.getLastName(), actor.getName(), actor.getSurname());
    }
}
