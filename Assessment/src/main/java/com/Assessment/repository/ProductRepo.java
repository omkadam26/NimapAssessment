package com.Assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Assessment.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}

