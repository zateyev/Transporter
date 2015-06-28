package com.epam.transporter.entity;

import java.util.ArrayList;

public class TrucksPark extends ArrayList<Truck> {

    private static final TrucksPark PARK_OF_TRUCKS = new TrucksPark();

    public static final TrucksPark getParkOfTrucks() {
        PARK_OF_TRUCKS.add(new TruckBuilder()
                .model("Газель")
                .capacityByWeight(1500)
                .capacityByVolume(9)
                .pricePerKm(30)
                .build());

        PARK_OF_TRUCKS.add(new TruckBuilder()
                .model("Scania")
                .capacityByWeight(8000)
                .capacityByVolume(56)
                .pricePerKm(70)
                .build());

        PARK_OF_TRUCKS.add(new TruckBuilder()
                .model("Foton")
                .capacityByWeight(3000)
                .capacityByVolume(20)
                .pricePerKm(50)
                .build());

        PARK_OF_TRUCKS.add(new TruckBuilder()
                .model("Газель")
                .capacityByWeight(1500)
                .capacityByVolume(9)
                .pricePerKm(30)
                .build());

        PARK_OF_TRUCKS.add(new TruckBuilder()
                .model("Daf")
                .capacityByWeight(20000)
                .capacityByVolume(100)
                .pricePerKm(100)
                .build());
        return PARK_OF_TRUCKS;
    }

}
