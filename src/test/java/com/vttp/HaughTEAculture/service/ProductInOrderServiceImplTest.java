package com.vttp.HaughTEAculture.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.vttp.HaughTEAculture.model.Cart;
import com.vttp.HaughTEAculture.model.ProductInOrder;
import com.vttp.HaughTEAculture.model.User;
import com.vttp.HaughTEAculture.repository.ProductInOrderRepo;
import com.vttp.HaughTEAculture.service.implementation.ProductInOrderServiceImpl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class ProductInOrderServiceImplTest {

    @Mock
    private ProductInOrderRepo productInOrderRepository;

    @InjectMocks
    private ProductInOrderServiceImpl productInOrderService;

    private User user;

    private ProductInOrder productInOrder;

    @Before
    public void setUp() {
        user = new User();
        Cart cart = new Cart();

        productInOrder = new ProductInOrder();
        productInOrder.setProductId("1");

        Set set = new HashSet<>();
        set.add(productInOrder);

        cart.setProducts(set);

        user.setCart(cart);
    }

    @Test
    public void updateTest() {
        productInOrderService.update("1", 10, user);

        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder);
    }

    @Test
    public void findOneTest() {
        ProductInOrder productInOrderReturn = productInOrderService.findOne("1", user);

        assertThat(productInOrderReturn.getProductId(), is(productInOrder.getProductId()));
    }
}
