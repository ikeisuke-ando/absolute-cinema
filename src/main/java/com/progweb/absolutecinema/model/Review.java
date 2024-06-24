package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="review")
@Data
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name="text")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Setter
    @Getter
    private User user;


    public Review() {
    }

    public Review(Long id, String title, double rating, String text, User user) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.upVote = 0;
        this.downVote = 0;
        this.text = Objects.requireNonNullElse(text, "");
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
