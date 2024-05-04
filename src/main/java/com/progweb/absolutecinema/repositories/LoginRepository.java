package com.progweb.absolutecinema.repositories;

import com.progweb.absolutecinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<User,Long> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from user where id = :id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value="SELECT * FROM user WHERE email =:email AND password =:password", nativeQuery = true)
    public User findByEmail(String email, String password);
    @Query(value="SELECT * FROM user WHERE login =:login AND password =:password", nativeQuery = true)
    public User findByUsername(String login, String password);

}
