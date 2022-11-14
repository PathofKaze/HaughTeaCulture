package com.vttp.HaughTEAculture.service;

import com.vttp.HaughTEAculture.model.Cart;
import com.vttp.HaughTEAculture.model.ProductInOrder;
import com.vttp.HaughTEAculture.model.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
