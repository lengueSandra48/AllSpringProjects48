package com.Product_Inventory.repository;


import com.Product_Inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByQuantityLessThan(int threshold);
}

