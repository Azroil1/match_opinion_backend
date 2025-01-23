package ru.amirmanyanov.matchopinion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.amirmanyanov.matchopinion.models.entity.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Genre findByGenre(String name);
}
