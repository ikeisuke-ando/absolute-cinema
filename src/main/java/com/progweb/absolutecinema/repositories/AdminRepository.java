package com.progweb.absolutecinema.repositories;

import com.progweb.absolutecinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User,Long> {

}
