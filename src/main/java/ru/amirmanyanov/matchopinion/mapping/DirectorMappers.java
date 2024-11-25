package ru.amirmanyanov.matchopinion.mapping;

import ru.amirmanyanov.matchopinion.models.dto.DirectorDto;
import ru.amirmanyanov.matchopinion.models.entity.Director;

public class DirectorMappers {
    public static DirectorDto toDto(Director director) {
        return new DirectorDto(director.getLastName(), director.getName(), director.getSurname());
    }
}
