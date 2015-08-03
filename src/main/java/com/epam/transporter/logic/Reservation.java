package com.epam.transporter.logic;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.TruckDao;
import com.epam.transporter.entity.*;

public class Reservation {

    public static void reserveTruck(Truck truck) {
        truck.setStatus(TruckStatus.RESERVED);
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        jdbcTruckDao.update(truck);
    }

    public static void freeTruck(Truck truck) {
        truck.setStatus(TruckStatus.EMPTY);
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        jdbcTruckDao.update(truck);
    }
}
