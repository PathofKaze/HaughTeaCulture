package com.vttp.HaughTEAculture.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.vttp.HaughTEAculture.error.OrderStatusError;
import com.vttp.HaughTEAculture.model.OrderMain;
import com.vttp.HaughTEAculture.model.ProductInOrder;
import com.vttp.HaughTEAculture.model.ProductInfo;
import com.vttp.HaughTEAculture.repository.OrderRepo;
import com.vttp.HaughTEAculture.repository.ProductInfoRepo;
import com.vttp.HaughTEAculture.service.implementation.OrderServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepo orderRepository;

    @Mock
    private ProductInfoRepo productInfoRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderServiceImpl orderService;

    private OrderMain orderMain;

    private ProductInfo productInfo;

    @Before
    public void setUp() {
        orderMain = new OrderMain();
        orderMain.setOrderId(1L);
        orderMain.setOrderStatus(OrderStatusError.NEW.getCode());

        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setProductId("1");
        productInOrder.setCount(10);

        Set<ProductInOrder> set = new HashSet<>();
        set.add(productInOrder);

        orderMain.setProducts(set);

        productInfo = new ProductInfo();
        productInfo.setProductStock(10);
    }

    @Test
    public void finishSuccessTest() {
        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);

        OrderMain orderMainReturn = orderService.finish(orderMain.getOrderId());

        assertThat(orderMainReturn.getOrderId(), is(orderMain.getOrderId()));
        assertThat(orderMainReturn.getOrderStatus(), is(OrderStatusError.FINISHED.getCode()));
    }

    @Test(expected = Exception.class)
    public void finishStatusCanceledTest() {
        orderMain.setOrderStatus(OrderStatusError.CANCELED.getCode());

        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);

        OrderMain orderMainReturn = orderService.finish(orderMain.getOrderId());

        assertThat(orderMainReturn.getOrderId(), is(orderMain.getOrderId()));
        assertThat(orderMainReturn.getOrderStatus(), is(OrderStatusError.FINISHED.getCode()));
    }

    @Test(expected = Exception.class)
    public void finishStatusFinishedTest() {
        orderMain.setOrderStatus(OrderStatusError.FINISHED.getCode());

        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);

        OrderMain orderMainReturn = orderService.finish(orderMain.getOrderId());

        assertThat(orderMainReturn.getOrderId(), is(orderMain.getOrderId()));
        assertThat(orderMainReturn.getOrderStatus(), is(OrderStatusError.FINISHED.getCode()));
    }

    @Test
    public void cancelSuccessTest() {
        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);
        when(productInfoRepository.findByProductId(orderMain.getProducts().iterator().next().getProductId())).thenReturn(productInfo);

        OrderMain orderMainReturn = orderService.cancel(orderMain.getOrderId());

        assertThat(orderMainReturn.getOrderId(), is(orderMain.getOrderId()));
        assertThat(orderMainReturn.getOrderStatus(), is(OrderStatusError.CANCELED.getCode()));
        assertThat(orderMainReturn.getProducts().iterator().next().getCount(), is(10));
    }

    @Test
    public void cancelNoProduct() {
        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);
        orderMain.setProducts(new HashSet<>());

        OrderMain orderMainReturn = orderService.cancel(orderMain.getOrderId());

        assertThat(orderMainReturn.getOrderId(), is(orderMain.getOrderId()));
        assertThat(orderMainReturn.getOrderStatus(), is(OrderStatusError.CANCELED.getCode()));
    }

    @Test(expected = Exception.class)
    public void cancelStatusCanceledTest() {
        orderMain.setOrderStatus(OrderStatusError.CANCELED.getCode());

        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);

        orderService.cancel(orderMain.getOrderId());
    }

    @Test(expected = Exception.class)
    public void cancelStatusFinishTest() {
        orderMain.setOrderStatus(OrderStatusError.FINISHED.getCode());

        when(orderRepository.findByOrderId(orderMain.getOrderId())).thenReturn(orderMain);

        orderService.cancel(orderMain.getOrderId());
    }
}
