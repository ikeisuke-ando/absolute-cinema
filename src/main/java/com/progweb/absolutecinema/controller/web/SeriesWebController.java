package com.progweb.absolutecinema.controller.web;

import com.progweb.absolutecinema.model.Series;
import com.progweb.absolutecinema.services.SeriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/series")
public class SeriesWebController {

    private SeriesService seriesService;

    public SeriesWebController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/createSeries")
    public String create(){
        return "series/create-series";
    }

    @GetMapping("/listSeries")
    public String list() {
        return "series/list-series";
    }

    @GetMapping("/{id}")
    public String detailsSeries(@PathVariable Long id, Model model) {
        try {
            Optional<Series> series = seriesService.listById(id);

            if (series.isPresent()) {
                model.addAttribute("series", series.get());
                model.addAttribute("countTotalSeries", seriesService.countTotalSeries());
                return "series/details-series";
            }
            throw new Exception("Deu um erro.");
        } catch (Exception e) {
            return "redirect:/series/listSeries";
        }
    }

}
