package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Actor;
import org.hibernate.Session;

public class ActorDAO extends AbstractDAO<Actor> {

    public ActorDAO(Session session) {
        super(session, Actor.class);
    }
}
