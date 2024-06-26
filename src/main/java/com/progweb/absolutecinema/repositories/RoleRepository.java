package com.progweb.absolutecinema.repositories;

import com.progweb.absolutecinema.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
