package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Category;
import org.hibernate.Session;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO(Session session) {
        super(session, Category.class);
    }
}
