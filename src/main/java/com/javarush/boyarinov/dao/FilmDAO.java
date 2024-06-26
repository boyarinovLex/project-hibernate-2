package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Film;
import org.hibernate.Session;

public class FilmDAO extends AbstractDAO<Film> {

    public FilmDAO(Session session) {
        super(session, Film.class);
    }
}
