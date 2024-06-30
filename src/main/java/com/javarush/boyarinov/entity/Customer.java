package com.javarush.boyarinov.entity;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @ToString.Exclude
    private Store store;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    @ToString.Exclude
    private Address address;

    @Column(name = "active")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "create_date")
    @ToString.Exclude
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;
}
