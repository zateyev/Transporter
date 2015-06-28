package com.epam.transporter.logic;

import com.epam.transporter.entity.Goods;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.TrucksPark;

public class Order {
    private DeliveryPoints deliveryFromTo;
    private Goods goods;
    private Integer price;

    public Order(DeliveryPoints deliveryFromTo, Goods goods) {
        this.deliveryFromTo = deliveryFromTo;
        this.goods = goods;
    }

    public Integer getPrice() {
        Integer tmp = 0;
        if (goods.getWeight() >= 200 && goods.getWeight() < 1500) {
            tmp = deliveryFromTo.calculateDistance() * TrucksPark.getTrucksList().get(0).getPricePerKm();
            price = tmp;
        } else if (goods.getWeight() >= 1500 && goods.getWeight() < 3000) {
            tmp = deliveryFromTo.calculateDistance() * TrucksPark.getTrucksList().get(2).getPricePerKm();
            price = tmp;
        } else if (goods.getWeight() >= 3000 && goods.getWeight() < 5000) {
            tmp = deliveryFromTo.calculateDistance() * TrucksPark.getTrucksList().get(3).getPricePerKm();
            price = tmp;
        } else if (goods.getWeight() >= 5000 && goods.getWeight() < 8000) {
            tmp = deliveryFromTo.calculateDistance() * TrucksPark.getTrucksList().get(1).getPricePerKm();
            price = tmp;
        } else if (goods.getWeight() >= 8000 && goods.getWeight() < 20000) {
            tmp = deliveryFromTo.calculateDistance() * TrucksPark.getTrucksList().get(4).getPricePerKm();
            price = tmp;
        }
        return price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public DeliveryPoints getDeliveryFromTo() {
        return deliveryFromTo;
    }

    public void setDeliveryFromTo(DeliveryPoints deliveryFromTo) {
        this.deliveryFromTo = deliveryFromTo;
    }
}
