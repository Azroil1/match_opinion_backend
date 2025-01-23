package ru.amirmanyanov.matchopinion.models.dto;

import java.util.Set;

public record FilmDto(String title, int year, String description, String ageLimit, String urlPhoto, String urlTrailer, String urlFilms, boolean isOscar, Set<ActorDto> actors, Set<DirectorDto> directors, Set<CountryDto> countries, Set<GenreDto> genres, String idFilm) {
}
