package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.builders.OrderBuilder;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> findOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream()
                .map(OrderBuilder::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findOrderById(long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            LOGGER.error("Order with id {} was not found in db", id);
            throw new ResourceNotFoundException(Order.class.getSimpleName() + " with id: " + id);
        }
        return OrderBuilder.toOrderDTO(orderOptional.get());
    }

    public long insert(OrderDTO orderDTO) {
        Order order = OrderBuilder.fromOrderDTO(orderDTO);
        order = orderRepository.save(order);
        LOGGER.debug("Order with id {} was inserted in db", order.getId_order());
        return order.getId_order();
    }

    public void deleteOrderById(long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.delete(orderOptional.get());
        } else {
            throw new ResourceNotFoundException(Order.class.getSimpleName() + " with id: " + id);
        }
    }

    public OrderDTO updateOrder(long id, OrderDTO orderDTO) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            LOGGER.error("Order with id {} was not found in db", id);
            throw new ResourceNotFoundException(Order.class.getSimpleName() + " with id: " + id);
        }

        Order existingOrder = orderOptional.get();
        existingOrder.setNbOfProducts(orderDTO.getNbOfProducts());
        existingOrder.setTotal_price(orderDTO.getTotal_price());

        Order updatedOrder = orderRepository.save(existingOrder);
        LOGGER.debug("Order with id {} was updated in db", updatedOrder.getId_order());

        return OrderBuilder.toOrderDTO(updatedOrder);
    }
}
