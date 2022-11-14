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
import com.vttp.HaughTEAculture.repository.CartRepo;
import com.vttp.HaughTEAculture.repository.OrderRepo;
import com.vttp.HaughTEAculture.repository.ProductInOrderRepo;
import com.vttp.HaughTEAculture.service.implementation.CartServiceImpl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class CartServiceImplTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private ProductService productService;

    @Mock
    private ProductInOrderRepo productInOrderRepository;

    @Mock
    private CartRepo cartRepository;

    @Mock
    private OrderRepo orderRepository;

    private User user;

    private ProductInOrder productInOrder;

    private Set<ProductInOrder> set;

    private Cart cart;

    @Before
    public void setUp() {
        user = new User();
        cart = new Cart();

        user.setEmail("email@email.com");
        user.setName("Name");
        user.setPhone("Phone Test");
        user.setAddress("Address Test");

        productInOrder = new ProductInOrder();
        productInOrder.setProductId("1");
        productInOrder.setCount(10);
        productInOrder.setProductPrice(BigDecimal.valueOf(1));

        set = new HashSet<>();
        set.add(productInOrder);

        cart.setProducts(set);

        user.setCart(cart);
    }

    @Test
    public void mergeLocalCartTest() {
        cartService.mergeLocalCart(set, user);

        Mockito.verify(cartRepository, Mockito.times(1)).save(cart);
        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder);
    }

    @Test
    public void mergeLocalCartTwoProductTest() {
        ProductInOrder productInOrder2 = new ProductInOrder();
        productInOrder2.setProductId("2");
        productInOrder2.setCount(10);

        user.getCart().getProducts().add(productInOrder2);

        cartService.mergeLocalCart(set, user);

        Mockito.verify(cartRepository, Mockito.times(1)).save(cart);
        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder);
        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder2);
    }

    @Test
    public void mergeLocalCartNoProductTest() {
        user.getCart().setProducts(new HashSet<>());

        cartService.mergeLocalCart(set, user);

        Mockito.verify(cartRepository, Mockito.times(1)).save(cart);
        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder);
    }

    @Test
    public void deleteTest() {
        cartService.delete("1", user);

        Mockito.verify(productInOrderRepository, Mockito.times(1)).deleteById(productInOrder.getId());
    }

    @Test(expected = Exception.class)
    public void deleteNoProductTest() {
        cartService.delete("", user);
    }

    @Test(expected = Exception.class)
    public void deleteNoUserTest() {
        cartService.delete("1", null);
    }

    @Test
    public void checkoutTest() {
        cartService.checkout(user);

        Mockito.verify(productInOrderRepository, Mockito.times(1)).save(productInOrder);
    }
}
