package org.microservices.grpc.controller;



import org.microservices.grpc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String createOrder(@RequestParam int productId, @RequestParam int quantity) {
        return orderService.createOrder(productId, quantity);
    }
}
