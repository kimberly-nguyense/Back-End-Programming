package com.example.demo.entities.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id",nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name="excursions",
            joinColumns = @JoinColumn(name="excursion_id"),
            inverseJoinColumns = @JoinColumn(name="cart_item_id"))
    private Set<Excursion> excursions;
    @ManyToOne
    @JoinColumn(name="division_id",nullable = false)
    private Cart cart;

    @Column(name="create_date")
    private Date create_date;
    @Column(name="last_update")
    private Date last_update;

    public CartItem(){}
}
