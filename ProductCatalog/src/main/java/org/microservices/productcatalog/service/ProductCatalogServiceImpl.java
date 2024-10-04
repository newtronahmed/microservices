package org.microservices.productcatalog.service;

import io.grpc.stub.StreamObserver;
import org.microservices.productcatalog.ProductCatalogServiceGrpc;
import org.microservices.productcatalog.ProductRequest;
import org.microservices.productcatalog.ProductResponse;
import org.microservices.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogServiceImpl extends ProductCatalogServiceGrpc.ProductCatalogServiceImplBase {

    @Autowired
    private ProductService productService;

    @Override
    public void getProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        Optional<Product> productOpt = productService.getProductById((long) request.getProductId());

        ProductResponse response;
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            response = ProductResponse.newBuilder()
                    .setProductId(Math.toIntExact(product.getId()))
                    .setName(product.getName())
                    .setPrice(product.getPrice())
                    .setDescription(product.getDescription())
                    .build();
        } else {
            response = ProductResponse.newBuilder()
                    .setProductId(request.getProductId())
                    .setName("Unknown")
                    .setPrice(0)
                    .build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
