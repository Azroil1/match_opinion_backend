package ru.amirmanyanov.matchopinion.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.amirmanyanov.matchopinion.models.dto.CountryDto;
import ru.amirmanyanov.matchopinion.models.dto.GenreDto;
import ru.amirmanyanov.matchopinion.repository.sotring.SortCriteria;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmRoom implements Match, Serializable {
    private static final long serialVersionUID = 2L;
    private String nameRoom;
    private Set<Long> roomMembers;
    private String idRoom;
    private Long idFoundersRoom;
    private int nowCount;
    private long totalCount;
    private ConcurrentHashMap<String, Set<Long>> likeFilmInRoom;
    private Set<GenreDto> genreDtoSet;
    private Set<CountryDto> countryDtoSet;
    private SortCriteria sortCriteria;
    private ConcurrentMap<String,Long> countLikesForFilm;

    public FilmRoom(Long idFoundersRoom, long totalCount, String nameRoom, Set<GenreDto> genreDtoSet, Set<CountryDto> countryDtoSet, SortCriteria sortCriteria) {
        this.idFoundersRoom = idFoundersRoom;
        this.nowCount = 1;
        this.totalCount = totalCount;
        this.idRoom = UUID.randomUUID().toString() + totalCount + UUID.randomUUID();
        roomMembers = new HashSet<>();
        roomMembers.add(idFoundersRoom);
        this.nameRoom = nameRoom;
        this.likeFilmInRoom = new ConcurrentHashMap<>();
        this.genreDtoSet = genreDtoSet;
        this.countryDtoSet = countryDtoSet;
        this.sortCriteria = sortCriteria;
    }

    @Override
    public boolean match(String filmId,Long clientLike) {
        boolean flag = this.countLikeForFilm(filmId , clientLike).get(filmId) == this.nowCount;
        return flag && nowCount > 1;
    }

    private ConcurrentMap<String, Integer> countLikeForFilm(String idFilm, Long clientLike) {
        if (likeFilmInRoom == null) {
            likeFilmInRoom = new ConcurrentHashMap<>();
            Set<String> setLikes = new HashSet<>();
            setLikes.add(clientLike.toString());
            likeFilmInRoom.put(idFilm, new HashSet<>());
        }
        else {
            if(likeFilmInRoom.containsKey(idFilm)){
                likeFilmInRoom.get(idFilm).add(clientLike);
            }
            else{
                Set<Long> setLikes = new HashSet<>();
                setLikes.add(clientLike);
                likeFilmInRoom.put(idFilm, setLikes);
            }
        }
        return likeFilmInRoom.entrySet().stream().collect(Collectors.toConcurrentMap(Map.Entry::getKey, e -> e.getValue().size()));
    }


    @Override
    public String getMatch(){
        try{
            if(countLikesForFilm != null) {
                //return match film
                return this.countLikesForFilm.entrySet().stream().filter(e -> e.getValue() == nowCount).findFirst().get().getKey();
            }
        } catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<String> getAllMatch(){
        return countLikesForFilm.entrySet().stream().filter(e -> e.getValue() == nowCount).map(Map.Entry::getKey).toList();
    }
}
