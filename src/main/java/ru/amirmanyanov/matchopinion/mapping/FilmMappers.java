package ru.amirmanyanov.matchopinion.mapping;

import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.entity.Film;

import java.util.stream.Collectors;

public class FilmMappers {
    public static FilmDto toDto(Film film){
        return new FilmDto(film.getTitle(), film.getYear(), film.getDescription(),
                film.getAgeLimit(), film.getUrlPhoto(), film.getUrlTrailer(), film.getUrlFilms(),
                film.isOscars(), film.getActors().stream().map(ActorMappers::toDto).collect(Collectors.toSet()),
                film.getDirectors().stream().map(DirectorMappers::toDto).collect(Collectors.toSet()),
                film.getCountries().stream().map(CountryMappers::toDto).collect(Collectors.toSet()),
                film.getGenres().stream().map(GenreMappers::toDto).collect(Collectors.toSet()));
    }
}
