package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Category.class);
    }

    public Set<Category> getByNames(List<String> categories) {
        Session session = getSessionCreator().getSession();
        Query<Category> query = session.createQuery("SELECT c FROM Category c WHERE c.name IN(:CATEGORIES)", Category.class);
        query.setParameter("CATEGORIES", categories);
        List<Category> list = query.list();
        return Set.copyOf(list);
    }
}
