package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.entity.Film;
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
    @GetMapping("getfilm/{room}/{id}")
    public ResponseEntity<Slice<Film>> getFilm(@PathVariable String room, @PathVariable long id) throws Exception {
        return ResponseEntity.ok(filmService.getFilmByUser(room,id));

    }
}
