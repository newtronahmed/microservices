package org.microservices.grpc.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {
    private int productId;
    private String price;
    private String name;


}
