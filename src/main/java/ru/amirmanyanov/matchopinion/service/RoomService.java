package ru.amirmanyanov.matchopinion.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.amirmanyanov.matchopinion.mapping.FilmMappers;
import ru.amirmanyanov.matchopinion.match.FilmRoom;
import ru.amirmanyanov.matchopinion.match.UserFilms;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.dto.RoomDto;
import ru.amirmanyanov.matchopinion.models.dto.response.NewRoom;
import ru.amirmanyanov.matchopinion.models.entity.Film;
import ru.amirmanyanov.matchopinion.repository.FilmRepository;
import ru.amirmanyanov.matchopinion.repository.RedisRepository;

import java.util.*;

@Service
public class RoomService {
    private final RedisRepository redisRepository;
    private final FilmRepository filmRepository;

    public RoomService(RedisRepository redisRepository, FilmRepository filmRepository) {
        this.redisRepository = redisRepository;
        this.filmRepository = filmRepository;
    }

    public NewRoom createRoom(RoomDto roomDto) throws Exception {
        FilmRoom filmRoom = new FilmRoom(roomDto.idCreator(), roomDto.countMembers(), roomDto.nameRoom(), roomDto.genres(),roomDto.countries(),roomDto.sortCriteria());
        if(redisRepository.getObject("user" + filmRoom.getIdFoundersRoom()) == null){
            UserFilms user = new UserFilms(roomDto.idCreator());
            Map<String, String> rooms = new HashMap<>();
            rooms.put(filmRoom.getIdRoom(), filmRoom.getNameRoom());
            user.setIdUserRoomsAndNameRooms(rooms);
            redisRepository.save("user" + roomDto.idCreator(), user, 1);
        }
        else{
            UserFilms userFilms = (UserFilms) redisRepository.getObject("user" + roomDto.idCreator());
            userFilms.getIdUserRoomsAndNameRooms().put(filmRoom.getIdRoom(), filmRoom.getNameRoom());
            redisRepository.save("user" + roomDto.idCreator(), userFilms, 1);
            //redisRepository.save();
        }
        redisRepository.save(filmRoom.getIdRoom(), filmRoom, 2);
        return new NewRoom(filmRoom.getIdRoom(), roomDto.nameRoom());
    }

    public NewRoom enterRoom(String idRoom, Long user) throws Exception {
        FilmRoom filmRoom = (FilmRoom) redisRepository.getObject(idRoom);
        UserFilms userFilms = (UserFilms) redisRepository.getObject("user" + user);
        if(userFilms == null){
            userFilms = new UserFilms(user);
        }
        if(filmRoom.getNowCount() < filmRoom.getTotalCount()){
            filmRoom.setNowCount(filmRoom.getNowCount() + 1);
            Map<String, String> roomsPage = userFilms.getIdUserRoomsAndNameRooms();
            if(roomsPage == null){
                roomsPage = new HashMap<>();
                roomsPage.put(idRoom, filmRoom.getNameRoom());
            }
            else{
                roomsPage.put(idRoom, filmRoom.getNameRoom());
            }
            redisRepository.save(filmRoom.getIdRoom(), filmRoom, 2);
            redisRepository.save("user" + user, userFilms , 1);
            return new NewRoom(filmRoom.getIdRoom(), filmRoom.getNameRoom());
        }
        throw new Exception();
    }

    public FilmDto asyncGetMatch(String idFilm, String idRoom, Long idClient) throws Exception {
        FilmRoom filmRoom = (FilmRoom) redisRepository.getObject(idRoom);
        if(filmRoom != null){
            if(filmRoom.match(idFilm,idClient)){
                return FilmMappers.toDto(filmRepository.findById(UUID.fromString(idFilm)).get());
            }
        }
        return null;
    }
}
