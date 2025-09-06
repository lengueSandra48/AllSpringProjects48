package com.Product_Inventory.service;

import com.Product_Inventory.model.Product;
import com.Product_Inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    public Product update(Long id, Product product) {
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return productRepository.save(existing);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findByQuantityLessThan(5);
    }

}
