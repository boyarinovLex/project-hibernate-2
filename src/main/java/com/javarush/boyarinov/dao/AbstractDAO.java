package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
public abstract class AbstractDAO<T> {

    private final SessionCreator sessionCreator;
    private final Class<T> aClass;

    public T create(T entity) {
        sessionCreator.getSession().persist(entity);
        return entity;
    }

    public T getById(Integer id) {
        return sessionCreator.getSession().find(aClass, id);
    }

    public List<T> getAll() {
        return sessionCreator.getSession().createQuery("FROM " + aClass.getSimpleName(), aClass).list();
    }

    public List<T> getItems(int offset, int limit) {
        Query<T> query = sessionCreator.getSession().createQuery("FROM " + aClass.getSimpleName(), aClass);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public T update(T entity) {
        return sessionCreator.getSession().merge(entity);
    }

    public void delete(T entity) {
        sessionCreator.getSession().remove(entity);
    }

    public void deleteById(Integer id) {
        T entity = getById(id);
        sessionCreator.getSession().remove(entity);
    }

}
