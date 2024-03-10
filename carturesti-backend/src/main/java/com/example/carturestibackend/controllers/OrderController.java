package com.example.carturestibackend.controllers;

import com.example.carturestibackend.services.OrderService;
import com.example.carturestibackend.dtos.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> dtos = orderService.findOrders();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertOrder(@Valid @RequestBody OrderDTO orderDTO) {
        long orderID = orderService.insert(orderDTO);
        return new ResponseEntity<>(orderID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id_order}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("id_order") long orderID) {
        OrderDTO dto = orderService.findOrderById(orderID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_order}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id_order") long orderID) {
        orderService.deleteOrderById(orderID);
        return new ResponseEntity<>("Order with ID " + orderID + " deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_order}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable("id_order") long orderID, @Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(orderID, orderDTO);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
}
