package com.progweb.absolutecinema.repositories;

import com.progweb.absolutecinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<Movie,Long> {
}
