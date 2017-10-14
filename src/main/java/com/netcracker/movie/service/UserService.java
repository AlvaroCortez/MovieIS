package com.netcracker.movie.service;

import com.netcracker.movie.model.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}
