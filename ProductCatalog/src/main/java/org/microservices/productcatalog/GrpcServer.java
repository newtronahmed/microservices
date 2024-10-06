package org.microservices.productcatalog;

import org.microservices.productcatalog.service.ProductCatalogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcServer implements CommandLineRunner {


    @Autowired
    private ProductCatalogServiceImpl productCatalogService;
//    private int port = 9090;
    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder
                .forPort(9091)
                .addService(productCatalogService)
                .build();

        server.start();
        System.out.println("gRPC server started on port " + 9091);
        server.awaitTermination();
    }
}