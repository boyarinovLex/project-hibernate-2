package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.entity.Staff;
import org.hibernate.Session;

public class StaffDAO extends AbstractDAO<Staff> {

    public StaffDAO(Session session) {
        super(session, Staff.class);
    }
}
