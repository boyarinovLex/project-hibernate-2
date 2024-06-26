package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Payment;
import org.hibernate.Session;

public class PaymentDAO extends AbstractDAO<Payment> {

    public PaymentDAO(Session session) {
        super(session, Payment.class);
    }
}
