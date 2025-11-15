package org.example.controller;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //Create product
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        service.save(product);
    }

    //Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    //Get product by id
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Update product
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product) {
        service.update(product, id);
    }

    //Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }

}
