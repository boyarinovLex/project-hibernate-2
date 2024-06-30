package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.City;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CityDAO extends AbstractDAO<City> {

    public CityDAO(SessionCreator sessionCreator) {
        super(sessionCreator, City.class);
    }

    public City getByName(String name) {
        Session session = getSessionCreator().getSession();
        Query<City> query = session.createQuery("SELECT c FROM City c WHERE c.city = :NAME", City.class);
        query.setParameter("NAME", name);
        return query.uniqueResult();
    }
}
