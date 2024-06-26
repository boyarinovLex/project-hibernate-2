package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Film;

public class FilmDAO extends AbstractDAO<Film> {

    public FilmDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Film.class);
    }
}
