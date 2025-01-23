package ru.amirmanyanov.matchopinion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.amirmanyanov.matchopinion.models.entity.Country;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Integer> {
    Country findByCountry(String name);
}
