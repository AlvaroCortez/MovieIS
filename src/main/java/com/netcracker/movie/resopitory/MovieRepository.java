package com.netcracker.movie.resopitory;

import com.netcracker.movie.model.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

}
