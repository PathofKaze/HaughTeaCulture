package com.vttp.HaughTEAculture.service;

import com.vttp.HaughTEAculture.model.User;

import java.util.Collection;

public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
