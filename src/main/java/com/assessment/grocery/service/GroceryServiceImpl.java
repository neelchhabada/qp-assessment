package com.assessment.grocery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.grocery.entity.GroceryItem;
import com.assessment.grocery.repository.GroceryItemRepository;

@Service
public class GroceryServiceImpl implements GroceryService{

  @Autowired
  private GroceryItemRepository groceryItemRepository;

  @Override
  public List<GroceryItem> getAllGroceryItems() {
    return groceryItemRepository.findAll();
  }

  @Override
  @Transactional
  public GroceryItem addGroceryItem(GroceryItem groceryItem) {
    return groceryItemRepository.save(groceryItem);
  }

  @Override
  @Transactional
  public void removeGroceryItem(Long itemId) {
    groceryItemRepository.deleteById(itemId);
  }

  @Override
  @Transactional
  public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedGroceryItem) {
    Optional<GroceryItem> result = groceryItemRepository.findById(itemId);

    GroceryItem existingItem = null;
    if (result.isPresent()) {
      existingItem = result.get();
    }
    else {
      throw new RuntimeException("Did not find any grocery id - " + itemId);
    }

    existingItem.setName(updatedGroceryItem.getName());
    existingItem.setPrice(updatedGroceryItem.getPrice());
    existingItem.setInventory(updatedGroceryItem.getInventory());

    return groceryItemRepository.save(existingItem);
  }
}
