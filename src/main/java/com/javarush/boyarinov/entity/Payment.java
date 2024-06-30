package com.javarush.boyarinov.entity;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @ToString.Exclude
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "rental_id")
    @ToString.Exclude
    private Rental rental;

    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;
}
