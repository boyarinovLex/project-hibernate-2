package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Inventory;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class InventoryDAO extends AbstractDAO<Inventory> {

    public InventoryDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Inventory.class);
    }

    public Inventory getAnyAvailableFilmForRent(Integer storeId) {
        Session session = getSessionCreator().getSession();
        Query<Inventory> query = session.createQuery("SELECT i FROM Inventory i JOIN Rental r ON i.id = r.inventory.id WHERE r.returnDate IS NOT NULL AND i.store.id = :STORE_ID", Inventory.class);
        query.setParameter("STORE_ID", storeId);
        return query.list().stream().findAny().orElse(null);
    }
}
