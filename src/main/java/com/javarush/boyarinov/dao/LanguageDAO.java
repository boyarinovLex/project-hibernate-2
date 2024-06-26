package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Language;
import org.hibernate.Session;

public class LanguageDAO extends AbstractDAO<Language> {

    public LanguageDAO(Session session) {
        super(session, Language.class);
    }
}
