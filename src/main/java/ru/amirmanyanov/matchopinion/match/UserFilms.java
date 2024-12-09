package ru.amirmanyanov.matchopinion.match;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class UserFilms implements LikesAndDislikeInterface {
    @Getter
    private final Long userId;
    @Getter
    @Setter
    private Set<String> userRooms;
    @Setter
    private Set<String> likeFilms;
    @Setter
    private Set<String> dislikeFilms;
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
