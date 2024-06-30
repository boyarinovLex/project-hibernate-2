package com.javarush.boyarinov.config;

import com.javarush.boyarinov.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {

    private final SessionFactory sessionFactory;
    private Session session;

    public SessionCreator() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        session = session == null || !session.isOpen()
                ? sessionFactory.openSession()
                : session;
        return session;
    }

    public void close() {
        sessionFactory.close();
    }

}
