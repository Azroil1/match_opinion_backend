package ru.amirmanyanov.matchopinion.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.amirmanyanov.matchopinion.models.entity.Film;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    List<Film> findFilmByTitle(String title);
    List<Film> findAll();
    @Override
    Page<Film> findAll(Pageable pageable);
}
