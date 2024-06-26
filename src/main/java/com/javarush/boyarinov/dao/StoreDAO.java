package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Store;
import org.hibernate.Session;

public class StoreDAO extends AbstractDAO<Store> {

    public StoreDAO(Session session) {
        super(session, Store.class);
    }
}
