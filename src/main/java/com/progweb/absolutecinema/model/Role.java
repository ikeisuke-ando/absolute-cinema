package com.progweb.absolutecinema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true)
    private Long roleId;
    @Column(name = "role_name")
    private String name;


    public enum Values {
        ADMIN(1L),
        BASIC(2L);

        Long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }

        public long getRoleId() {
            return roleId;
        }
    }
}
