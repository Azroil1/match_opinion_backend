package ru.amirmanyanov.matchopinion.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private int year;
    private String description;
    @Column(name = "age_limit")
    private String ageLimit;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "url_trailer")
    private String urlTrailer;
    @Column(name = "url_films")
    private String urlFilms;
    @Column(name = "oscars")
    private boolean oscars;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_actors",
    joinColumns = @JoinColumn(name = "id_film"),
    inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private Set<Actor> actors;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_director",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_director")
    )
    private Set<Director> directors;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private Set<Genre> genres;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_country",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_country")
    )
    private Set<Country> countries;
}
