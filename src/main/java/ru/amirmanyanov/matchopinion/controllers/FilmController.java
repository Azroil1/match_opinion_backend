package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.entity.Film;
import ru.amirmanyanov.matchopinion.repository.FilmRepository;
import ru.amirmanyanov.matchopinion.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/allfilms")
    public List<FilmDto> getAllFilms() {
        return filmService.getAllFilms();
    }
}
