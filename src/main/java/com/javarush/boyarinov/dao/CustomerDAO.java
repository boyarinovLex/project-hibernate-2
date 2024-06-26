package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Customer;

public class CustomerDAO extends AbstractDAO<Customer> {

    public CustomerDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Customer.class);
    }
}
