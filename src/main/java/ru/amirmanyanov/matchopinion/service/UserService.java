package ru.amirmanyanov.matchopinion.service;

import org.springframework.stereotype.Service;
import ru.amirmanyanov.matchopinion.exceptions.UserNotFoundException;
import ru.amirmanyanov.matchopinion.match.UserFilms;
import ru.amirmanyanov.matchopinion.models.dto.response.AllRoomsUser;
import ru.amirmanyanov.matchopinion.repository.RedisRepository;

@Service
public class UserService {

    private final RedisRepository redisRepository;

    public UserService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    //Метод для получения всех комнат юзера, где он учавсвует
    public AllRoomsUser getAllRoomsUser(Long user) throws UserNotFoundException {
        UserFilms userFilms = getUserFilms(user);
        return new AllRoomsUser(userFilms.getIdUserRoomsAndNameRooms());
    }


    private UserFilms getUserFilms(Long user) throws UserNotFoundException {
        try{
            return (UserFilms) redisRepository.getObject("user" + user);
        }catch(Exception e){
            throw new UserNotFoundException();
        }

    }
}
