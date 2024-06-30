package com.javarush.boyarinov.entity;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer id;

    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    @ToString.Exclude
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @ToString.Exclude
    private Staff staff;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;

}
