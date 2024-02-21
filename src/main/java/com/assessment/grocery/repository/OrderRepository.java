package com.assessment.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.grocery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
