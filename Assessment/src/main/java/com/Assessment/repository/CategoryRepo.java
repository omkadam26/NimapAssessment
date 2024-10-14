package com.Assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Assessment.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
	
}

