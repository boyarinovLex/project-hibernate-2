package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Language;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LanguageDAO extends AbstractDAO<Language> {

    public LanguageDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Language.class);
    }

    public Language getByName(String nameLanguage) {
        Session session = getSessionCreator().getSession();
        Query<Language> query = session.createQuery("SELECT l FROM Language l WHERE l.name = :NAME", Language.class);
        query.setParameter("NAME", nameLanguage);
        return query.getSingleResult();
    }
}
