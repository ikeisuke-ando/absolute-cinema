package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="series")
public class Series {

    public static final String TABLE_NAME = "series";

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;


    @Setter
    @Getter
    @Column(name="name", length = 255, nullable = false)
    private String name;

    @Setter
    @Getter
    @Column(name="series_genre", nullable = false)
    private String seriesGenre;

    @Setter
    @Getter
    @Column(name="poster")
    private String poster;

    @Setter
    @Getter
    @Column(name="year", nullable = false)
    private int year;

    @Setter
    @Getter
    @Column(name="rating", nullable = true)
    private double rating;

    @Setter
    @Getter
    @Column(name="episodes", nullable = false)
    private int episodes;

    @Setter
    @Getter
    @JoinColumn(name="reviews")
    @OneToMany(targetEntity = Review.class)
    private List<Review> reviews;

    @Setter
    @Getter
    @Column(name="gallery", length = 255, nullable = false)
    private String gallery;

    public Series(){
    }

    public Series(Long id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
}
