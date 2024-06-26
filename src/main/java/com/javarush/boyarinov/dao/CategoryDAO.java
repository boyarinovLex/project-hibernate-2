package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Category;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Category.class);
    }
}
