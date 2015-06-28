package com.epam.transporter.entity;

import java.util.ArrayList;
import java.util.List;

public class TrucksPark {
    private static List<Truck> trucks = new ArrayList<>();

    public static final List<Truck> getTrucksList() {
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
                .model("Газель")
                .capacityByWeight(1500)
                .capacityByVolume(9)
                .pricePerKm(30)
                .build());
        trucks.add(new TruckBuilder()
                .model("Daf")
                .capacityByWeight(20000)
                .capacityByVolume(100)
                .pricePerKm(100)
                .build());
        return trucks;
    }
}
