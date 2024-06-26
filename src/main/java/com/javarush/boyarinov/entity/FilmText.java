package com.javarush.boyarinov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "film_text")
public class FilmText {

    @Id
    @Column(name = "film_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private String title;

    private String description;
}
