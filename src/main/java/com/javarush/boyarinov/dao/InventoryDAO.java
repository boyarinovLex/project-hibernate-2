package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Inventory;
import org.hibernate.Session;

public class InventoryDAO extends AbstractDAO<Inventory> {

    public InventoryDAO(Session session) {
        super(session, Inventory.class);
    }
}
