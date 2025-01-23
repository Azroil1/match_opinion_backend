package ru.amirmanyanov.matchopinion.repository.specifications;


import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.amirmanyanov.matchopinion.models.entity.Country;
import ru.amirmanyanov.matchopinion.models.entity.Film;
import ru.amirmanyanov.matchopinion.models.entity.Genre;
import ru.amirmanyanov.matchopinion.repository.sotring.SortCriteria;
import ru.amirmanyanov.matchopinion.repository.sotring.SortOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FilmSpecification {
    public static Specification<Film> filterAndSortFilms(Set<String> genres, Set<String> countries, SortCriteria sortCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Фильтрация по жанрам
            if (genres != null && !genres.isEmpty()) {
                Join<Film, Genre> genreJoin = root.join("genres");
                predicates.add(genreJoin.get("genre").in(genres));
            }

            // Фильтрация по странам
            if (countries != null && !countries.isEmpty()) {
                Join<Film, Country> countryJoin = root.join("countries");
                predicates.add(countryJoin.get("country").in(countries));
            }

            // Установка сортировки
            if (sortCriteria != null) {
                Objects.requireNonNull(query).orderBy(
                        sortCriteria.getSortOrder() == SortOrder.ASC
                                ? criteriaBuilder.asc(root.get(sortCriteria.getSortField().getValue()))
                                : criteriaBuilder.desc(root.get(sortCriteria.getSortField().getValue()))
                );
            } else {
                // Сортировка по умолчанию
                Objects.requireNonNull(query).orderBy(criteriaBuilder.asc(root.get("rating")));
            }

            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
