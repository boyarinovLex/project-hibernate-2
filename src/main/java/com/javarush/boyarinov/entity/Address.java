package com.javarush.boyarinov.entity;


import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column
    private String address;

    @Column(name = "address2")
    private String secondAddress;

    @Column
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private String phone;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;

}
