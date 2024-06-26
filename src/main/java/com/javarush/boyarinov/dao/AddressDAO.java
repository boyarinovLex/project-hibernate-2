package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;

public class AddressDAO extends AbstractDAO<AddressDAO> {

    public AddressDAO(SessionCreator sessionCreator) {
        super(sessionCreator, AddressDAO.class);
    }
}
