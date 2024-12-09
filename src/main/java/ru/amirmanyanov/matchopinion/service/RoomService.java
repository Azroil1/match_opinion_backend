package ru.amirmanyanov.matchopinion.service;

import org.springframework.stereotype.Service;
import ru.amirmanyanov.matchopinion.match.FilmRoom;
import ru.amirmanyanov.matchopinion.match.UserFilms;
import ru.amirmanyanov.matchopinion.models.dto.RoomDto;
import ru.amirmanyanov.matchopinion.models.dto.response.NewRoom;
import ru.amirmanyanov.matchopinion.repository.RedisRepository;

@Service
public class RoomService {
    private final RedisRepository redisRepository;

    public RoomService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    public NewRoom createRoom(RoomDto roomDto) throws Exception {
        FilmRoom filmRoom = new FilmRoom(roomDto.idCreator(), roomDto.countMembers(), roomDto.nameRoom());
        if(redisRepository.getObject("user" + filmRoom.getIdFoundersRoom()) == null){
            redisRepository.save("user" + roomDto.idCreator(), new UserFilms(roomDto.idCreator()), 1);
        }
        redisRepository.save(filmRoom.getIdRoom(), filmRoom, 2);
        return new NewRoom(filmRoom.getIdRoom(), roomDto.nameRoom());
    }
}
