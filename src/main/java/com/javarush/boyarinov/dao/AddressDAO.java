package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Address;

public class AddressDAO extends AbstractDAO<Address> {

    public AddressDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Address.class);
    }
}
