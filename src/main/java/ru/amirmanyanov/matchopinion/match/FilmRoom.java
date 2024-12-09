package ru.amirmanyanov.matchopinion.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmRoom implements Match, Serializable {
    private static final long serialVersionUID = 2L;
    private String nameRoom;
    private Set<UserFilms> roomMembers;
    private String idRoom;
    private Long idFoundersRoom;
    private long nowCount;
    private long totalCount;
    private Map<String, Set<UserFilms>> memberLikeFilms;

    public FilmRoom(Long idFoundersRoom, long totalCount, String nameRoom) {
        this.idFoundersRoom = idFoundersRoom;
        this.nowCount = 1;
        this.totalCount = totalCount;
        this.idRoom = UUID.randomUUID().toString() + totalCount + UUID.randomUUID();
        roomMembers = new HashSet<>();
        roomMembers.add(new UserFilms(idFoundersRoom));
        this.nameRoom = nameRoom;
    }

    @Override
    public boolean match() {
        boolean flag = countLikeForFilm().containsValue(nowCount);
        return flag && nowCount > 1;
    }

    private Map<String, Long> countLikeForFilm() {
        return memberLikeFilms.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .filter(e -> e.getUserRooms().contains(idRoom))
                .map(UserFilms::getLikes)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(filmId -> filmId, Collectors.counting()));
    }

    @Override
    public String getMatch(){
        try{
            if(match()) {
                //return match film
                return countLikeForFilm().entrySet().stream().filter(e -> e.getValue() == nowCount).findFirst().get().getKey();
            }
        } catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
