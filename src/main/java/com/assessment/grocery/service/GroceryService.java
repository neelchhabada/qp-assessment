package com.assessment.grocery.service;

import java.util.List;

import com.assessment.grocery.entity.GroceryItem;

public interface GroceryService {

  List<GroceryItem> getAllGroceryItems();

  GroceryItem addGroceryItem(GroceryItem groceryItem);

  void removeGroceryItem(Long itemId);

  GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedGroceryItem);
}
