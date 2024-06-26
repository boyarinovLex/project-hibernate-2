package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Payment;

public class PaymentDAO extends AbstractDAO<Payment> {

    public PaymentDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Payment.class);
    }
}
