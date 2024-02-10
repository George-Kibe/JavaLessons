package org.test.crudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.crudproject.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    Optional<Object> findByName(String name);
    Product findByName(String name);

}
