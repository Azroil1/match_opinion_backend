package ru.amirmanyanov.matchopinion.repository;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.amirmanyanov.matchopinion.models.entity.Film;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    @EntityGraph(attributePaths = {"actors", "directors", "countries", "genres"})
    @Query("SELECT DISTINCT f FROM Film f")
    List<Film> findAll();

}
