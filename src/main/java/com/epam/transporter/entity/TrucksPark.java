package com.epam.transporter.entity;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.TruckDao;

import java.util.ArrayList;
import java.util.List;

public class TrucksPark {
    public static List<Truck> getTrucksListFromDb() {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        return jdbcTruckDao.getTrucksList();
    }

    public static List<Truck> getSuitableEmptyTrucks(Order order) {
        Weightiness weightiness = order.getGoods().typeByWeight();
        List<Truck> truckList = new ArrayList<>();
        for (Truck truck : getTrucksListFromDb()) {
            if (truck.typeByLoadCapacity().equals(weightiness) && truck.isEmpty()) {
                truckList.add(truck);
            }
        }
        return truckList;
    }

    public static Truck getTruckByLoadCapacity(Weightiness weightiness) {
        for (Truck truck : getTrucksListFromDb()) {
            if (truck.typeByLoadCapacity().equals(weightiness)) {
                return truck;
            }
        }
        throw new TrucksParkException("No trucks suitable to the request");
    }

    public synchronized static Truck reserveTruck(Long truckId) {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        Truck truck = jdbcTruckDao.findById(truckId);
        truck.setStatus(Truck.Status.RESERVED);
        jdbcTruckDao.update(truck);
        return truck;
    }
}
