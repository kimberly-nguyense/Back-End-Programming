package com.example.demo.entities.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cartItems")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id")
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name="excursions",
            joinColumns = @JoinColumn(name="cart_item_id"),
            inverseJoinColumns = @JoinColumn(name="excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @Column(name="create_date")
    private Date create_date;
    @Column(name="last_update")
    private Date last_update;

    public CartItem(){}
}
