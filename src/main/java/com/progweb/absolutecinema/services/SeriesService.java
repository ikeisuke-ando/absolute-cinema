package com.progweb.absolutecinema.services;


import com.progweb.absolutecinema.model.Series;
import com.progweb.absolutecinema.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    public Series create(Series series) {
        return seriesRepository.save(series);
    }

    public Optional<Series> listById(Long id) {
        return seriesRepository.findById(id);
    }

    public Iterable<Series> listSeries () {
        return seriesRepository.findAll();
    }

    public Iterable<Series> listSeriesByRating () {
        return seriesRepository.findAllByOrderByRatingDesc();
    }


}
