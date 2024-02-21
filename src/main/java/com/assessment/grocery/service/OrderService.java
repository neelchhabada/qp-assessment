package com.assessment.grocery.service;

import java.util.List;

import com.assessment.grocery.entity.GroceryItem;
import com.assessment.grocery.entity.Order;

public interface OrderService {

  List<GroceryItem> getAllAvailableItems();

  Order createOrder(List<Long> itemIds);
}
