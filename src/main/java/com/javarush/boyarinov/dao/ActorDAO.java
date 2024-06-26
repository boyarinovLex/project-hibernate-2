package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Actor;

public class ActorDAO extends AbstractDAO<Actor> {

    public ActorDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Actor.class);
    }
}
