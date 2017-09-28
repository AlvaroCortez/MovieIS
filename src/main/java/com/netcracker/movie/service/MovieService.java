package com.netcracker.movie.service;

import com.netcracker.movie.model.Movie;

public interface MovieService {

    Iterable<Movie> listAllMovies();

    Movie getMovieById(Long id);

    Movie saveMovie(Movie movie);

    void deleteMovie(Long id);
}
