package org.microservices.productcatalog.repositories;

import org.microservices.productcatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

