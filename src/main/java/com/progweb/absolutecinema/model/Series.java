package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="series")
@Data
public class Series {

    public static final String TABLE_NAME = "series";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;


    @Column(name="title", length = 255, nullable = false)
    private String title;

    @Column(name="series_genre", nullable = false)
    private String seriesGenre;

    @Column(name="poster")
    private String poster;

    @Column(name="year", nullable = false)
    private int year;

    @Column(name="rating", nullable = true)
    private double rating;

    @Column(name="episodes", nullable = false)
    private int episodes;

    @Column(name="plot", nullable = false, columnDefinition = "TEXT")
    private String plot;

    @JoinColumn(name="reviews")
    @OneToMany(targetEntity = Review.class)
    private List<Review> reviews;

    @Column(name="gallery", length = 255)
    private String gallery;

    public Series(){
    }

    public Series(String title, String seriesGenre, int year, int episodes, String plot) {
        this.title = title;
        this.seriesGenre = seriesGenre;
        this.year = year;
        this.episodes = episodes;
        this.plot = plot;
    }
}
