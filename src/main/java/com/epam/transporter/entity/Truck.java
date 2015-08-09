package com.epam.transporter.entity;

public class Truck extends BaseEntity {
    private String model;
    private Integer capacityByWeight;
    private Integer capacityByVolume;
    private Integer pricePerKm;
    private Status status;

    public Truck(String model, Integer capacityByWeight, Integer capacityByVolume, Integer pricePerKm, Status status) {
        this.model = model;
        this.capacityByWeight = capacityByWeight;
        this.capacityByVolume = capacityByVolume;
        this.pricePerKm = pricePerKm;
        this.status = status;
    }

    public Weightiness typeByLoadCapacity() {
        if (this.capacityByWeight >= 200 && this.capacityByWeight <= 1500) return Weightiness.VERY_LIGHT;
        else if (this.capacityByWeight > 1500 && this.capacityByWeight <= 3000) return Weightiness.LIGHT;
        else if (this.capacityByWeight > 3000 && this.capacityByWeight <= 5000) return Weightiness.MEDIUM;
        else if (this.capacityByWeight > 5000 && this.capacityByWeight <= 8000) return Weightiness.HEAVY;
        else if (this.capacityByWeight > 8000 && this.capacityByWeight <= 20000) return Weightiness.VERY_HEAVY;
        else return null;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacityByWeight() {
        return capacityByWeight;
    }

    public void setCapacityByWeight(Integer capacityByWeight) {
        this.capacityByWeight = capacityByWeight;
    }

    public Integer getCapacityByVolume() {
        return capacityByVolume;
    }

    public void setCapacityByVolume(Integer capacityByVolume) {
        this.capacityByVolume = capacityByVolume;
    }

    public Integer getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(Integer pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return this.status == Status.EMPTY;
    }

    public enum Status {
        EMPTY, RESERVED, DEFECTIVE
    }
}
