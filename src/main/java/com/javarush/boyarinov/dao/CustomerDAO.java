package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Customer;
import org.hibernate.Session;

public class CustomerDAO extends AbstractDAO<Customer> {

    public CustomerDAO(Session session) {
        super(session, Customer.class);
    }
}
