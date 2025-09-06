package com.Product_Inventory.controller;

import com.Product_Inventory.model.Product;
import com.Product_Inventory.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Créer un produit")
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @Operation(summary = "Liste de tous les produits")
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @Operation(summary = "Voir un produit par ID")
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "Modifier un produit")
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @Operation(summary = "Supprimer un produit")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @Operation(summary = "Produits avec stock bas (< 5)")
    @GetMapping("/low-stock")
    public List<Product> getLowStock() {
        return productService.getLowStockProducts();
    }

}
