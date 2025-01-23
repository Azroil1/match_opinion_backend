package ru.amirmanyanov.matchopinion.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.amirmanyanov.matchopinion.models.entity.Film;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
//    @EntityGraph(attributePaths = {"actors", "directors", "countries", "genres"})
//    @Query("SELECT DISTINCT f FROM Film f")
//    List<Film> findAll();

    @EntityGraph(attributePaths = {"actors", "directors", "countries", "genres"})
    Slice<Film> findAll(Specification<Film> specification, Pageable pageable);

    @EntityGraph(attributePaths = {"actors", "directors", "countries", "genres"})
    Optional<Film> findById(UUID id);

}
