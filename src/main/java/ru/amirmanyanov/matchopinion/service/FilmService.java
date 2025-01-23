package ru.amirmanyanov.matchopinion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.amirmanyanov.matchopinion.mapping.FilmMappers;
import ru.amirmanyanov.matchopinion.match.FilmRoom;
import ru.amirmanyanov.matchopinion.match.UserFilms;
import ru.amirmanyanov.matchopinion.models.dto.FilmDto;
import ru.amirmanyanov.matchopinion.models.entity.Country;
import ru.amirmanyanov.matchopinion.models.entity.Film;
import ru.amirmanyanov.matchopinion.models.entity.Genre;
import ru.amirmanyanov.matchopinion.repository.CountriesRepository;
import ru.amirmanyanov.matchopinion.repository.FilmRepository;
import ru.amirmanyanov.matchopinion.repository.GenreRepository;
import ru.amirmanyanov.matchopinion.repository.RedisRepository;
import ru.amirmanyanov.matchopinion.repository.specifications.FilmSpecification;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final RedisRepository redisRepository;
    private static final int COUNT_FILMS = 10;
    private final GenreRepository genreRepository;
    private final CountriesRepository countriesRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, RedisRepository redisRepository, GenreRepository genreRepository, CountriesRepository countriesRepository) {
        this.filmRepository = filmRepository;
        this.redisRepository = redisRepository;
        this.genreRepository = genreRepository;
        this.countriesRepository = countriesRepository;
    }

    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream().map(FilmMappers::toDto).collect(Collectors.toList());
    }
    //Дописать логику
    public Slice<Film> getFilmByUser(String room, long user) throws Exception {
        System.out.println("getFilmByUser");
        FilmRoom filmRoom = (FilmRoom) redisRepository.getObject(room);
        System.out.println(filmRoom);
        if(filmRoom != null){
            System.out.println(user);
            UserFilms userFilms = (UserFilms) redisRepository.getObject("user" + user);
            System.out.println("user" + userFilms + user);
            if(userFilms != null && userFilms.getIdUserRoomsAndNameRooms().containsKey(room)){
                Set<String> genres = null;
                if(filmRoom.getGenreDtoSet() != null) {
                    genres = filmRoom.getGenreDtoSet().stream().map(e -> genreRepository.findByGenre(e.name()).getGenre()).filter(Objects::nonNull).collect(Collectors.toSet());
                    System.out.println(genres);
                }
                Set<String> countries = null;
                if(filmRoom.getCountryDtoSet() != null) {
                    countries = filmRoom.getCountryDtoSet().stream().map(e -> countriesRepository.findByCountry(e.name()).getCountry()).collect(Collectors.toSet());
                    System.out.println(countries);
                }
                Specification<Film> specification = FilmSpecification.filterAndSortFilms(genres,
                        countries, filmRoom.getSortCriteria());
                return filmRepository.findAll(specification, PageRequest.of(userFilms.getPage(), COUNT_FILMS));
            }
        }
        return null;
    }
}
