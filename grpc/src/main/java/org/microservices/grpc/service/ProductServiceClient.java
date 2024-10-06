package org.microservices.grpc.service;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.microservices.grpc.ProductRequest;
import org.microservices.grpc.ProductResponse;
import org.microservices.grpc.ProductCatalogServiceGrpc;
//import org.microservices.grpc.responses.ProductRequest;
//import org.microservices.grpc.responses.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProductServiceClient {
    @Value("${grpc.server.port}")
    private int grpcServerPort;

    @Value("${grpc.server.host}")
    private String grpcServerhost;
    private ProductCatalogServiceGrpc.ProductCatalogServiceBlockingStub productServiceStub;

    @PostConstruct
    private void init() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerhost, grpcServerPort)
                .usePlaintext()
                .build();

        productServiceStub = ProductCatalogServiceGrpc.newBlockingStub(channel);
    }

    public ProductResponse getProduct(int productId) {
        ProductRequest request = ProductRequest.newBuilder()
                .setProductId(productId)
                .build();
        return productServiceStub.getProduct(request);
    }
}