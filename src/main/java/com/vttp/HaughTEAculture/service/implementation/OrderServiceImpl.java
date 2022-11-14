package com.vttp.HaughTEAculture.service.implementation;

import com.vttp.HaughTEAculture.model.OrderMain;
import com.vttp.HaughTEAculture.model.ProductInOrder;
import com.vttp.HaughTEAculture.model.ProductInfo;
import com.vttp.HaughTEAculture.error.OrderStatusError;
import com.vttp.HaughTEAculture.error.ResultError;
import com.vttp.HaughTEAculture.exception.Exception;
import com.vttp.HaughTEAculture.repository.OrderRepo;
import com.vttp.HaughTEAculture.repository.ProductInOrderRepo;
import com.vttp.HaughTEAculture.repository.ProductInfoRepo;
import com.vttp.HaughTEAculture.repository.UserRepo;
import com.vttp.HaughTEAculture.service.ProductService;
import com.vttp.HaughTEAculture.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepository;
    @Autowired
    UserRepo userRepository;
    @Autowired
    ProductInfoRepo productInfoRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderRepo productInOrderRepository;

    @Override
    public Page<OrderMain> findAll(Pageable pageable) {
        return orderRepository.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable);
    }

    @Override
    public Page<OrderMain> findByStatus(Integer status, Pageable pageable) {
        return orderRepository.findAllByOrderStatusOrderByCreateTimeDesc(status, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerEmail(String email, Pageable pageable) {
        return orderRepository.findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(email, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable) {
        return orderRepository.findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(phone, pageable);
    }

    @Override
    public OrderMain findOne(Long orderId) {
        OrderMain orderMain = orderRepository.findByOrderId(orderId);
        if(orderMain == null) {
            throw new Exception(ResultError.ORDER_NOT_FOUND);
        }
        return orderMain;
    }

    @Override
    @Transactional
    public OrderMain finish(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if(!orderMain.getOrderStatus().equals(OrderStatusError.NEW.getCode())) {
            throw new Exception(ResultError.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusError.FINISHED.getCode());
        orderRepository.save(orderMain);
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain cancel(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if(!orderMain.getOrderStatus().equals(OrderStatusError.NEW.getCode())) {
            throw new Exception(ResultError.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusError.CANCELED.getCode());
        orderRepository.save(orderMain);

        Iterable<ProductInOrder> products = orderMain.getProducts();
        for(ProductInOrder productInOrder : products) {
            ProductInfo productInfo = productInfoRepository.findByProductId(productInOrder.getProductId());
            if(productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
        return orderRepository.findByOrderId(orderId);

    }
}
