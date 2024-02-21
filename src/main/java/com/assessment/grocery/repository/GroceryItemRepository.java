package com.assessment.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.grocery.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
