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
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    @ToString.Exclude
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "address_id")
    @ToString.Exclude
    private Address address;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;

}
