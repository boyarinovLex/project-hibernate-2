package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Inventory;

public class InventoryDAO extends AbstractDAO<Inventory> {

    public InventoryDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Inventory.class);
    }
}
