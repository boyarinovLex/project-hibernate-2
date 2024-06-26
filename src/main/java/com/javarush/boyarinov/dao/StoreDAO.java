package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Store;

public class StoreDAO extends AbstractDAO<Store> {

    public StoreDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Store.class);
    }
}
