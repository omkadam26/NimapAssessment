package com.Assessment.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Assessment.entity.Category;
import com.Assessment.entity.Product;
import com.Assessment.repository.CategoryRepo;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;


    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    
    public  List<Category> getAllCategories() {
        try {
			return categoryRepo.findAll();
		} catch (Exception e) {
			System.out.println("No Record Found.. ");
			e.printStackTrace();
		}
		return null;
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = getCategoryById(id);
        category.setName(updatedCategory.getName());
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
