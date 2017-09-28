package com.netcracker.movie.resopitory;

import com.netcracker.movie.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
