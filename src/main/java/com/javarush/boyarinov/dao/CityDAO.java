package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.City;
import org.hibernate.Session;

public class CityDAO extends AbstractDAO<City> {

    public CityDAO(Session session) {
        super(session, City.class);
    }
}
