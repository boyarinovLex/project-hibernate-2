package com.javarush.boyarinov.entity;

import com.javarush.boyarinov.converter.RatingConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;

    private String title;

    private String description;

    @Column(name = "release_year")
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column
    private Integer length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    private Rating rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    @ToString.Exclude
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    @ToString.Exclude
    private Set<Actor> actors = new HashSet<>();

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;

    public Set<Feature> getSpecialFeatures() {
        if (Objects.isNull(specialFeatures)) {
            return null;
        }

        return Arrays.stream(specialFeatures.split(","))
                .map(Feature::getFeatureBy)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public void setSpecialFeatures(Set<Feature> specialFeatures) {
        if (Objects.isNull(specialFeatures)) {
            this.specialFeatures = null;
        }

        this.specialFeatures = specialFeatures.stream()
                .map(Feature::getValue)
                .collect(Collectors.joining(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}

