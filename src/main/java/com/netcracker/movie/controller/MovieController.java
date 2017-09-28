package com.netcracker.movie.controller;

import com.netcracker.movie.model.Movie;
import com.netcracker.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("movies", movieService.listAllMovies());
        return "listmovies";
    }

    @RequestMapping("movie/show/{id}")
    public String showMovie(@PathVariable Long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie";
    }

    @RequestMapping("movie/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movieform";
    }

    @RequestMapping("movie/new")
    public String newMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @RequestMapping(value = "movie", method = RequestMethod.POST)
    public String saveMovie(Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movie/show/" + movie.getId();
    }

    @RequestMapping("movie/delete/{id}")
    public String delete(@PathVariable Long id){
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
