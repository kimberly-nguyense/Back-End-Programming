package com.example.demo.entities.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;
    @Column(name="package_price")
    private BigDecimal package_price;
    @Column(name="party_size")
    private int party_size;

    @Enumerated(EnumType.ORDINAL)
    private StatusType status;
    @Column(name="create_date")
    private Date create_date;
    @Column(name="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>();

    public enum StatusType{
        pending, ordered, canceled
    }
    public Cart(){}
}
