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

    /*public static final List<Truck> getTrucksList() {
        trucks.add(new TruckBuilder()
                .model("Газель")
                .capacityByWeight(1500)
                .capacityByVolume(9)
                .pricePerKm(30)
                .build());
        trucks.add(new TruckBuilder()
                .model("Scania")
                .capacityByWeight(8000)
                .capacityByVolume(56)
                .pricePerKm(70)
                .build());
        trucks.add(new TruckBuilder()
                .model("Foton")
                .capacityByWeight(3000)
                .capacityByVolume(20)
                .pricePerKm(50)
                .build());
        trucks.add(new TruckBuilder()
                .model("KamAz")
                .capacityByWeight(5000)
                .capacityByVolume(12)
                .pricePerKm(60)
                .build());
        trucks.add(new TruckBuilder()
                .model("Daf")
                .capacityByWeight(20000)
                .capacityByVolume(100)
                .pricePerKm(100)
                .build());
        return trucks;
    }*/

    public static Truck getTruckByLoadCapacity(Weightiness weightiness) {
        for (Truck truck : getTrucksListFromDb()) {
            if (truck.typeByLoadCapacity().equals(weightiness)) {
                return truck;
            }
        }
        throw new TrucksParkException("No trucks suitable to the request");
    }
}
