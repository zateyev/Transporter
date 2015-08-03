package com.epam.transporter.entity;

public class TruckBuilder {
    private String model;
    private Integer capacityByWeight;
    private Integer capacityByVolume;
    private Integer pricePerKm;
    private String status;
    private Long id;

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

    public TruckBuilder status(final String status) {
        this.status = status;
        return this;
    }

    public TruckBuilder id(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    /*public Truck build() {
        return new Truck(this);
    }*/
}
