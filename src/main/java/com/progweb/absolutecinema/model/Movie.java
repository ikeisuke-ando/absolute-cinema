package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="movie")
public class Movie {
    public static final String TABLE_NAME = "movie";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    @Column(name="id", unique = true)
    private Long id;

    @Setter
    @Getter
    @Column(name="name", nullable = false)
    private String name;

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
    @Column(name="rating")
    private double rating;

    @Setter
    @Getter
    @JoinColumn(name="reviews")
    @OneToMany(targetEntity = Review.class)
    private List<Review> reviews;

    @Setter
    @Getter
    @Column(name="gallery")
    private String gallery;


}
