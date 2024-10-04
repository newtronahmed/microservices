package org.microservices.grpc.service;


import org.microservices.grpc.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductServiceClient productServiceClient;

    public String createOrder(int productId, int quantity) {
        ProductResponse product = productServiceClient.getProduct(productId);
        double totalPrice = product.getPrice() * quantity;

        // Here you would typically save the order to a database

        return String.format("Order created for %d units of %s. Total price: $%.2f",
                quantity, product.getName(), totalPrice);
    }
}