package com.epam.transporter.logic;

import com.epam.transporter.entity.TrucksPark;

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
        if (order.getGoods().getWeight() >= 200 && order.getGoods().getWeight() < 1500) {
            tmp = order.getDeliveryFromTo().calculateDistance() * TrucksPark.getTrucksList().get(0).getPricePerKm();
            price = tmp;
        } else if (order.getGoods().getWeight() >= 1500 && order.getGoods().getWeight() < 3000) {
            tmp = order.getDeliveryFromTo().calculateDistance() * TrucksPark.getTrucksList().get(2).getPricePerKm();
            price = tmp;
        } else if (order.getGoods().getWeight() >= 3000 && order.getGoods().getWeight() < 5000) {
            tmp = order.getDeliveryFromTo().calculateDistance() * TrucksPark.getTrucksList().get(3).getPricePerKm();
            price = tmp;
        } else if (order.getGoods().getWeight() >= 5000 && order.getGoods().getWeight() < 8000) {
            tmp = order.getDeliveryFromTo().calculateDistance() * TrucksPark.getTrucksList().get(1).getPricePerKm();
            price = tmp;
        } else if (order.getGoods().getWeight() >= 8000 && order.getGoods().getWeight() < 20000) {
            tmp = order.getDeliveryFromTo().calculateDistance() * TrucksPark.getTrucksList().get(4).getPricePerKm();
            price = tmp;
        }
        return price;
    }
}
