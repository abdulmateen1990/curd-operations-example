package org.example.service;

import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product p) {
        return productRepository.save(p);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product update(Product newProduct, Long id) {
        return productRepository.findById(id).map(p ->
        {
            p.setName(newProduct.getName());
            p.setPrice(newProduct.getPrice());
            return productRepository.save(p);
        }).orElse(null);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
