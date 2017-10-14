package com.netcracker.movie.service;

import com.netcracker.movie.model.Movie;
import com.netcracker.movie.resopitory.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> listAllMovies(Integer id) {
        return this.movieRepository.findAll(new PageRequest(id, 10));
    }

    @Override
//    public Optional<Movie> getMovieById(Long id) {
    public Movie getMovieById(Long id) {
//        return this.movieRepository.findById(id);
        return this.movieRepository.findOne(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
//        this.movieRepository.deleteById(id);
        this.movieRepository.delete(id);
    }
}
