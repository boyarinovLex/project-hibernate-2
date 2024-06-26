package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.FilmText;
import org.hibernate.Session;

public class FilmTextDAO extends AbstractDAO<FilmText> {

    public FilmTextDAO(Session session) {
        super(session, FilmText.class);
    }
}
