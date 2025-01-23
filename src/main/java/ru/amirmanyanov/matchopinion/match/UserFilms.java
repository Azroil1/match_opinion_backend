package ru.amirmanyanov.matchopinion.match;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
@NoArgsConstructor
public class UserFilms implements LikesAndDislikeInterface {
    @Getter
    //сделать final и конструктор по умолчанию
    private Long userId;
    @Getter
    @Setter
    private Map<String, String> idUserRoomsAndNameRooms;
    @Setter
    @Getter
    private Set<String> likeFilms;
    @Setter
    @Getter
    private Set<String> dislikeFilms;
    @Setter
    @Getter
    private int page = 0;
    public UserFilms(Long userId) {
        this.userId = userId;
    }
    public UserFilms(Long userId, Set<String> likeFilms, Set<String> dislikeFilms) {
        this.userId = userId;
        this.likeFilms = likeFilms;
        this.dislikeFilms = dislikeFilms;
    }

    public void addLikesFilm(String film) {
        likeFilms.add(film);
    }
    public void addDislikesFilm(String film) {
        dislikeFilms.add(film);
    }

    @Override
    public Set<String> getLikes() {
        return likeFilms;
    }

    @Override
    public Set<String> getDislikes() {
        return dislikeFilms;
    }
}
