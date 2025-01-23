package ru.amirmanyanov.matchopinion.models.dto;

import ru.amirmanyanov.matchopinion.models.entity.Genre;
import ru.amirmanyanov.matchopinion.repository.sotring.SortCriteria;

import java.util.Set;

public record RoomDto(Long idCreator, Set<Long> membersRoom, int countMembers, String nameRoom, String nameCreator, Set<GenreDto> genres, Set<CountryDto> countries, SortCriteria sortCriteria) {
}
