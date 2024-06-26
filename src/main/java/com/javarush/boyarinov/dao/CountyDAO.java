package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Country;
import org.hibernate.Session;

public class CountyDAO extends AbstractDAO<Country> {

    public CountyDAO(Session session) {
        super(session, Country.class);
    }
}
