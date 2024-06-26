package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Country;

public class CountyDAO extends AbstractDAO<Country> {

    public CountyDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Country.class);
    }
}
