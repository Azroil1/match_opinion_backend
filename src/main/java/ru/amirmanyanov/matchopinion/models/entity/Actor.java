package ru.amirmanyanov.matchopinion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "actors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
}
