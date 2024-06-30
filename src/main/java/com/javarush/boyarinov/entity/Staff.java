package com.javarush.boyarinov.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @ToString.Exclude
    private Address address;

    @Lob
    @ToString.Exclude
    private Byte[] picture;

    private String email;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @ToString.Exclude
    private Store store;

    @Column(name = "active")
    private Boolean isActive;

    @ToString.Exclude
    private String username;

    @ToString.Exclude
    private String password;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @ToString.Exclude
    private Timestamp lastUpdate;

}
