package com.epam.transporter.entity;

public class Truck {
    private final String model;
    private final Integer capacityByWeight;
    private final Integer capacityByVolume;
    private final Integer pricePerKm;

    Truck(final TruckBuilder truckBuilder) {
        this.model = truckBuilder.getModel();
        this.capacityByWeight = truckBuilder.getCapacityByWeight();
        this.capacityByVolume = truckBuilder.getCapacityByVolume();
        this.pricePerKm = truckBuilder.getPricePerKm();
    }

    public String getModel() {
        return model;
    }

    public Integer getCapacityByWeight() {
        return capacityByWeight;
    }

    public Integer getCapacityByVolume() {
        return capacityByVolume;
    }

    public Integer getPricePerKm() {
        return pricePerKm;
    }
}
