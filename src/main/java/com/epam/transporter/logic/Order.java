package com.epam.transporter.logic;

import com.epam.transporter.entity.Goods;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.TrucksPark;

public class Order {
    private DeliveryPoints deliveryFromTo;
    private Goods goods;

    public Order() {
    }

    public Order(DeliveryPoints deliveryFromTo, Goods goods) {
        this.deliveryFromTo = deliveryFromTo;
        this.goods = goods;
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
