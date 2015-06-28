package com.epam.transporter.logic;

import com.epam.transporter.entity.Cargo;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.TrucksPark;

public class Order {

    private DeliveryPoints deliveryFromTo;
    private Cargo cargo;
    private Integer price;

    public Order(DeliveryPoints deliveryFromTo, Cargo cargo) {
        this.deliveryFromTo = deliveryFromTo;
        this.cargo = cargo;
    }

    public Integer getPrice() {
        Integer tmp = 0;
        if (cargo.getWeight()>=200&&cargo.getWeight()<1500) {
            tmp = deliveryFromTo.calculateDistance()* TrucksPark.getParkOfTrucks().get(0).getPricePerKm();
            price = tmp;
        }
        else if (cargo.getWeight()>=1500&&cargo.getWeight()<3000) {
            tmp = deliveryFromTo.calculateDistance()* TrucksPark.getParkOfTrucks().get(2).getPricePerKm();
            price = tmp;
        }
        else if (cargo.getWeight()>=3000&&cargo.getWeight()<5000) {
            tmp = deliveryFromTo.calculateDistance()* TrucksPark.getParkOfTrucks().get(3).getPricePerKm();
            price = tmp;
        }
        else if (cargo.getWeight()>=5000&&cargo.getWeight()<8000) {
            tmp = deliveryFromTo.calculateDistance()* TrucksPark.getParkOfTrucks().get(1).getPricePerKm();
            price = tmp;
        }
        else if (cargo.getWeight()>=8000&&cargo.getWeight()<20000) {
            tmp = deliveryFromTo.calculateDistance()* TrucksPark.getParkOfTrucks().get(4).getPricePerKm();
            price = tmp;
        }
        return price;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public DeliveryPoints getDeliveryFromTo() {
        return deliveryFromTo;
    }

    public void setDeliveryFromTo(DeliveryPoints deliveryFromTo) {
        this.deliveryFromTo = deliveryFromTo;
    }
}
