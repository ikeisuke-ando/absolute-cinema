package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String name;

    @Column(name = "user_name", length = 50, nullable = false)
    @NotNull(message = "O nome de usuário não pode ser nulo.")
    @Size(max = 50, message = "O nome de usuário deve ter no máximo 50 caracteres.")
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @Column(name = "login", length = 50, nullable = false, unique = true)
    @NotNull(message = "O login não pode ser nulo.")
    @Size(max = 50, message = "O login deve ter no máximo 50 caracteres.")
    private String login;

    @Column(name = "password", nullable = false)
    @NotNull(message = "A senha não pode ser nula.")
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Getter
    @Setter
    @Column(name="admin", nullable = false)
    private Boolean admin = false;
    public User() {
    }

    public User(Long id, String name, String username, String email, String login, String password, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.login = login;
        this.password = password;
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
        review.setUser(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setUser(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
