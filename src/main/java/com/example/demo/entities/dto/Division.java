package com.example.demo.entities.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY) //load on demand
    @JoinColumn(name="country_id",nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name="country_id")
    private Long country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    public Division(){}
}
