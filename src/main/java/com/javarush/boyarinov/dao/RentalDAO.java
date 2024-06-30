package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Rental;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class RentalDAO extends AbstractDAO<Rental> {

    public RentalDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Rental.class);
    }

    public Rental getUnreturnedFilm() {
        Session session = getSessionCreator().getSession();
        Query<Rental> query = session.createQuery("SELECT r FROM Rental r WHERE r.returnDate IS NULL", Rental.class);
        query.setMaxResults(1);
        return query.uniqueResult();
    }
}
