package ru.amirmanyanov.matchopinion.mapping;

import ru.amirmanyanov.matchopinion.models.dto.GenreDto;
import ru.amirmanyanov.matchopinion.models.entity.Genre;

public class GenreMappers {
    public static GenreDto toDto(Genre genre) {
        if (genre == null || genre.getGenre() == null) return null;
        try{
            return GenreDto.valueOf(genre.getGenre().toUpperCase());
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Unknown genre " + genre.getGenre());
        }
    }
}
