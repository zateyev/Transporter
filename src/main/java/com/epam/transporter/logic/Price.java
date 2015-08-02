package com.epam.transporter.logic;

import com.epam.transporter.entity.Order;
import com.epam.transporter.entity.TrucksPark;
import com.epam.transporter.entity.Weightiness;

public class Price {
    private Order order;

    public Price(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getPrice() {
        Weightiness weightiness = order.getGoods().typeByWeight();
        return order.getDeliveryPoints().getDistance() * TrucksPark.getTruckByLoadCapacity(weightiness).getPricePerKm();
    }
}
