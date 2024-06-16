package com.example.demo.services;

import com.example.demo.entities.dto.Cart;
import com.example.demo.entities.dto.CartItem;
import com.example.demo.entities.dto.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
