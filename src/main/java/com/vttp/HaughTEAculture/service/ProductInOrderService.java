package com.vttp.HaughTEAculture.service;

import com.vttp.HaughTEAculture.model.ProductInOrder;
import com.vttp.HaughTEAculture.model.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}

