package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Language;

public class LanguageDAO extends AbstractDAO<Language> {

    public LanguageDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Language.class);
    }
}
