package ru.amirmanyanov.matchopinion.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.amirmanyanov.matchopinion.exceptions.UserNotFoundException;
import ru.amirmanyanov.matchopinion.models.dto.response.AllRoomsUser;
import ru.amirmanyanov.matchopinion.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<AllRoomsUser> getUserRooms(@PathVariable Long idUser) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getAllRoomsUser(idUser));
    }

}
