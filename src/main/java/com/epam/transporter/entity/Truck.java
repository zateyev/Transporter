package com.epam.transporter.entity;

public class Truck {
    private final Long id;
    private final String model;
    private final Integer capacityByWeight;
    private final Integer capacityByVolume;
    private final Integer pricePerKm;
    private final String status;


    Truck(final TruckBuilder truckBuilder) {
        this.id = truckBuilder.getId();
        this.model = truckBuilder.getModel();
        this.capacityByWeight = truckBuilder.getCapacityByWeight();
        this.capacityByVolume = truckBuilder.getCapacityByVolume();
        this.pricePerKm = truckBuilder.getPricePerKm();
        this.status = truckBuilder.getStatus();
    }

    public Weightiness typeByLoadCapacity() {
        if (this.capacityByWeight>=200&&this.capacityByWeight<=1500) return Weightiness.VERY_LIGHT;
        else if (this.capacityByWeight>1500&&this.capacityByWeight<=3000) return Weightiness.LIGHT;
        else if (this.capacityByWeight>3000&&this.capacityByWeight<=5000) return Weightiness.MEDIUM;
        else if (this.capacityByWeight>5000&&this.capacityByWeight<=8000) return Weightiness.HEAVY;
        else if (this.capacityByWeight>8000&&this.capacityByWeight<=20000) return Weightiness.VERY_HEAVY;
        else return null;
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

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
