package com.javarush.boyarinov.dao;

import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.Staff;

public class StaffDAO extends AbstractDAO<Staff> {

    public StaffDAO(SessionCreator sessionCreator) {
        super(sessionCreator, Staff.class);
    }
}
