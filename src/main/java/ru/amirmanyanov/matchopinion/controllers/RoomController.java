package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.dto.RoomDto;
import ru.amirmanyanov.matchopinion.models.dto.response.NewRoom;
import ru.amirmanyanov.matchopinion.service.RoomService;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(path = "/createRoom", method = RequestMethod.GET)
    public ResponseEntity<NewRoom> createRoom(@RequestBody RoomDto roomDto) throws Exception {
        NewRoom roomResponse = roomService.createRoom(roomDto);
        return ResponseEntity.ok(roomResponse);
    }

    @RequestMapping(path = "/join/{idRoom}")
    public ResponseEntity<NewRoom> joinTheRoom(@PathVariable String idRoom, @RequestBody Long user) {
        NewRoom joinRoom = null;
        try {
            joinRoom = roomService.enterRoom(idRoom, user);
        }catch(Exception e){
            return (ResponseEntity<NewRoom>) ResponseEntity.internalServerError();
        }
        return ResponseEntity.ok(joinRoom);
    }
    @Async
    @RequestMapping(path = "/getMatch/{idRoom}/{idClient}", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<FilmDto>> asyncGetMatch(@RequestBody String idFilm, @ PathVariable String idRoom, @PathVariable Long idClient) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return  roomService.asyncGetMatch(idFilm, idRoom, idClient);
            } catch (Exception e) {
                throw new RuntimeException(e + "supplyAsync");
            }
        }).thenApply(result -> {
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.noContent().build();
            }
        });
    }

    public ResponseEntity<Set<FilmDto>> getAllFilmMatchInRoom(@PathVariable String idRoom, @PathVariable Long idClient) {
        
        return null;
    }
}
