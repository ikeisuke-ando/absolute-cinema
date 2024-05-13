package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="review")
public class Review {

    public static final String TABLE_NAME = "review";

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;

    @Setter
    @Getter
    @Column(name="title", nullable = false)
    private String title;

    @Setter
    @Getter
    @Column(name="rating")
    private double rating;

    @Setter
    @Getter
    @Column(name="text", nullable = false)
    private String text;

    @Setter
    @Getter
    @Column(name="up_vote")
    private int upVote;

    @Setter
    @Getter
    @Column(name="down_vote")
    private int downVote;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;


    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Review() {
    }

    public Review(Long id, String title, double rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.upVote = 0;
        this.downVote = 0;
    }
}
