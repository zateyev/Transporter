package com.epam.transporter.logic;

import com.epam.transporter.entity.TrucksPark;
import com.epam.transporter.entity.Weightiness;

public class Price {
    private Order order;
    private Integer price;

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
        Integer tmp;
        switch (order.getGoods().typeByWeight()) {
            case VERY_LIGHT:
                tmp = order.getDeliveryPoints().getDistance() * TrucksPark.getTrucksList().get(0).getPricePerKm();
                price = tmp;
                break;
            case LIGHT:
                tmp = order.getDeliveryPoints().getDistance() * TrucksPark.getTrucksList().get(2).getPricePerKm();
                price = tmp;
                break;
            case MEDIUM:
                tmp = order.getDeliveryPoints().getDistance() * TrucksPark.getTrucksList().get(3).getPricePerKm();
                price = tmp;
                break;
            case HEAVY:
                tmp = order.getDeliveryPoints().getDistance() * TrucksPark.getTrucksList().get(1).getPricePerKm();
                price = tmp;
                break;
            case VERY_HEAVY:
                tmp = order.getDeliveryPoints().getDistance() * TrucksPark.getTrucksList().get(4).getPricePerKm();
                price = tmp;
                break;
        }
        return price;
    }
}
