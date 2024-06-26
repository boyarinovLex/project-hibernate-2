package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Rental;

public class RentalDAO extends AbstractDAO<Rental> {

    public RentalDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Rental.class);
    }
}
