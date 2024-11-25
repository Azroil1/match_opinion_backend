package ru.amirmanyanov.matchopinion.service;

import org.springframework.stereotype.Service;
import ru.amirmanyanov.matchopinion.mapping.FilmMappers;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.repository.FilmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream().map(FilmMappers::toDto).collect(Collectors.toList());
    }
}
