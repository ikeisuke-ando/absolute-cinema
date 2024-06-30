package com.progweb.absolutecinema.model;

import com.progweb.absolutecinema.controller.dto.LoginRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(Long id, String name, String username, String password, Set<Role> role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public boolean isLoginValid(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}
