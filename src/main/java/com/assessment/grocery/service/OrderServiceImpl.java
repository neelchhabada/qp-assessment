package com.assessment.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.grocery.entity.GroceryItem;
import com.assessment.grocery.entity.Order;
import com.assessment.grocery.repository.GroceryItemRepository;
import com.assessment.grocery.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private GroceryItemRepository groceryItemRepository;

  @Override
  public List<GroceryItem> getAllAvailableItems() {
    return groceryItemRepository.findAll();
  }

  @Override
  @Transactional
  public Order createOrder(List<Long> itemIds) {
    List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
    if(items.size() != itemIds.size()){
      throw new IllegalArgumentException("one or more grocery items not found");
    }
    Order order = new Order();
    order.setItems(items);
    return orderRepository.save(order);
  }
}
