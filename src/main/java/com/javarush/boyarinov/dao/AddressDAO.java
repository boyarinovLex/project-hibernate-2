package com.javarush.boyarinov.dao;

import org.hibernate.Session;

public class AddressDAO extends AbstractDAO<AddressDAO>{

    public AddressDAO(Session session) {
        super(session, AddressDAO.class);
    }
}
