package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
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

    @PostMapping("/createRoom")
    public ResponseEntity<?> createRoom(@RequestBody Long idFounderRoom, @RequestBody Integer countRoomMembers){
        
        return null;
    }
}
