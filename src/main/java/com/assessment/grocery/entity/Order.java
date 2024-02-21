package com.assessment.grocery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id", nullable = false)
  private Long id;

  @ManyToMany
  @JoinTable(name = "order_items",
             joinColumns = @JoinColumn(name = "order_id"),
             inverseJoinColumns = @JoinColumn(name = "grocery_item_id"))
  private List<GroceryItem> items;

  @Column(name = "user")
  private String user;

}
