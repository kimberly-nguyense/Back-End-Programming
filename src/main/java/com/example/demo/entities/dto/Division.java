package com.example.demo.entities.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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

    @ManyToOne (fetch = FetchType.LAZY) //load on demand
    @JoinColumn(name="country_id",nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name="id")
    private Long country_ID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country_id")
    private Set<Customer> customers;

    public Division(){}
    public void setCountry(Country country){
        this.country = country;
    }
}
