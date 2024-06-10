package com.progweb.absolutecinema.repositories;

import com.progweb.absolutecinema.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
}
