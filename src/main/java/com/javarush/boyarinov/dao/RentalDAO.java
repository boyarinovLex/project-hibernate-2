package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Rental;
import org.hibernate.Session;

public class RentalDAO extends AbstractDAO<Rental> {

    public RentalDAO(Session session) {
        super(session, Rental.class);
    }
}
