package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.City;

public class CityDAO extends AbstractDAO<City> {

    public CityDAO(SessionCreator sessionCreator) {
        super(sessionCreator, City.class);
    }
}
