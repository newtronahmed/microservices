package org.microservices.grpc.responses;


import lombok.Data;

@Data
public class ProductResponse {
    private String productId;
    private double price;
    private String name;
}
