package com.vttp.HaughTEAculture.repository;

import com.vttp.HaughTEAculture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;


public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
    Collection<User> findAllByRole(String role);

}
