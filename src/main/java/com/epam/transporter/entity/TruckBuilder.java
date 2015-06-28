package com.epam.transporter.entity;

/**
 * Created by Жасулан on 31.05.2015.
 */
public class TruckBuilder {

    private String model;
    private Integer capacityByWeight;
    private Integer capacityByVolume;
    private Integer pricePerKm;

    public TruckBuilder model(final String model) {
        this.model = model;
        return this;
    }

    public TruckBuilder capacityByWeight(final Integer capacityByWeight) {
        this.capacityByWeight = capacityByWeight;
        return this;
    }

    public TruckBuilder capacityByVolume(final Integer capacityByVolume) {
        this.capacityByVolume = capacityByVolume;
        return this;
    }

    public TruckBuilder pricePerKm(final Integer pricePerKm) {
        this.pricePerKm = pricePerKm;
        return this;
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

    public Truck build() {
        return new Truck(this);
    }
}
