package com.Assessment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assessment.entity.Category;
import com.Assessment.entity.Product;
import com.Assessment.repository.CategoryRepo;
import com.Assessment.repository.ProductRepo;

@Service
public class ProductServices {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product, Long categoryId) {
        // Fetch the category by ID, or throw an exception if not found
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
        
        // Set the category for the product
        product.setCategory(category);

        // Save the product with the associated category
        return productRepo.save(product);
    }


    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        return productRepo.save(product);
    }
    
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
