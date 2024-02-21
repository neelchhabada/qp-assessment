package com.assessment.grocery.controller;

import java.util.List;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.grocery.entity.GroceryItem;
import com.assessment.grocery.service.GroceryService;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private GroceryService groceryService;

  @GetMapping("/grocery-items")
  public List<GroceryItem> getAllGroceryItems(){
    return groceryService.getAllGroceryItems();
  }

  @PostMapping("/grocery-items")
  public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem){
    return groceryService.addGroceryItem(groceryItem);
  }

  @PutMapping("/grocery-items/{itemId}")
  public GroceryItem updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem){
    return groceryService.updateGroceryItem(itemId, updatedItem);
  }

  @DeleteMapping("/grocery-items/{itemId}")
  public void removeGroceryItem(@PathVariable Long itemId){
     groceryService.removeGroceryItem(itemId);
  }
}
