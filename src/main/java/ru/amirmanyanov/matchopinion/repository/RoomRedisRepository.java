package ru.amirmanyanov.matchopinion.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import ru.amirmanyanov.matchopinion.match.FilmRoom;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class RoomRedisRepository implements RedisRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public RoomRedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(String key, Object value, int days) {
        redisTemplate.opsForValue().set(key, value, days, TimeUnit.DAYS);
    }

    @Override
    public Object getObject(String key) throws Exception {
        Object objectGet = redisTemplate.opsForValue().get(key);
        if (objectGet != null && objectGet instanceof FilmRoom) {
            //NotFoundRoomException
            return objectGet;
        }
        throw new Exception();
    }
}
