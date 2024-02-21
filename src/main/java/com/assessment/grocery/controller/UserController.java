package com.assessment.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.grocery.entity.GroceryItem;
import com.assessment.grocery.entity.Order;
import com.assessment.grocery.service.OrderService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/grocery-items")
  public List<GroceryItem> getAllAvailableItems(){
    return orderService.getAllAvailableItems();
  }

  @PostMapping("/orders")
  public Order createOrder(@RequestBody List<Long> itemIds){
    return orderService.createOrder(itemIds);
  }
}
