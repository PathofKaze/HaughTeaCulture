package com.vttp.HaughTEAculture.repository;

import com.vttp.HaughTEAculture.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {
}
