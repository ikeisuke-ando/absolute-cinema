package com.progweb.absolutecinema.services;

import com.progweb.absolutecinema.model.Movie;
import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.model.Series;
import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.AdminRepository;
import com.progweb.absolutecinema.repositories.MovieRepository;
import com.progweb.absolutecinema.repositories.SeriesRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    private MovieRepository movieRepository;
    private SeriesRepository seriesRepository;

    @Transactional
    public Movie createMovie(Movie movie){
        return movie = this.movieRepository.save(movie);
    }
    @Transactional
    public Series createSeries(Series series){
        return series = this.seriesRepository.save(series);
    }

    @Transactional
    public Movie updateMovie(Movie movie){
        Movie updateMovie = findMovieById(movie.getId());
        updateMovie.setName(movie.getName());
        updateMovie.setYear(movie.getYear());
        updateMovie.setPoster(movie.getPoster());
        return this.movieRepository.save(movie);
    }
    @Transactional
    public Series updateSeries(Series series){
        Series updateSeries = findSeriesById(series.getId());
        updateSeries.setName(series.getName());
        updateSeries.setEpisodes(series.getEpisodes());
        updateSeries.setPoster(series.getPoster());
        return this.seriesRepository.save(series);
    }

    public Movie findMovieById(Long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);
        return movie.orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }
    public Series findSeriesById(Long id){
        Optional<Series> series = this.seriesRepository.findById(id);
        return series.orElseThrow(() -> new RuntimeException("Série não encontrada"));
    }

    public boolean isAdmin(User user){
        if (user.getAdmin()){
            return true;
        }
        return false;
    }
}
