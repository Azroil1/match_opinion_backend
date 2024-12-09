package ru.amirmanyanov.matchopinion.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository {
    void save(String key, Object value, int days);
    Object getObject(String key) throws Exception;
}
