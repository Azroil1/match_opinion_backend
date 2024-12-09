package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.amirmanyanov.matchopinion.models.dto.RoomDto;
import ru.amirmanyanov.matchopinion.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(path = "/createRoom", method = RequestMethod.GET)
    public ResponseEntity<?> createRoom(@RequestBody RoomDto roomDto) throws Exception {
        roomService.createRoom(roomDto);
        return null;
    }
}
