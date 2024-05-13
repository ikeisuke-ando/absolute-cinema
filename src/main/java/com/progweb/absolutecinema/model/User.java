package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name="user")
public class User {
    public interface CreateUser{}
    public interface UpdateUser{}

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;

    @Column(name="name", length = 255, nullable = false)
    @NotNull(groups  = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    private String name;

    @Column(name="email", length = 255, nullable = false, unique = true)
    @NotNull(groups  = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    private String email;

    @Column(name="login", length = 255, nullable = false, unique = true)
    @NotNull(groups  = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    private String login;

    @Column(name="password", length = 255, nullable = false)
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8)
    private String password;

//    @Column(name = "reviews")
//    @Null(groups  = {CreateUser.class, UpdateUser.class})
//    private  List<Reviews>  reviews;

    public User(){
    }

    public User(Long id, String name, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Reviews> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Reviews> reviews) {
//        this.reviews = reviews;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return result = prime * result + ((this.id==null) ? 0 : this.id.hashCode());

    }
}
