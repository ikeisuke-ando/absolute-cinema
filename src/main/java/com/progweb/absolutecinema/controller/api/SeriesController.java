package com.progweb.absolutecinema.controller.api;

import com.progweb.absolutecinema.model.Series;
import com.progweb.absolutecinema.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Series series) {
        try {
            seriesService.create(series);
            return ResponseEntity.ok("Série criada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar série: " + e.getMessage());
        }
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Optional<Series>> getSeriesById(Long id) {
        try {
            return ResponseEntity.ok(seriesService.listById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/listByRating")
    public ResponseEntity<Iterable<Series>> getSeriesByRating() {
        try {
            return ResponseEntity.ok(seriesService.listSeriesByRating());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<Iterable<Series>> getAllSeries() {
        try {
            Iterable<Series> seriesList = seriesService.listSeries();
            return ResponseEntity.ok(seriesList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
