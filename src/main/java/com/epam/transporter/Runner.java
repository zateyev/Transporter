package com.epam.transporter;

import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.entity.DeliveryPoints;

public class Runner {
    public static void main(String[] args) {
        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
        System.out.println(deliveryFromTo.calculateDistance());
        Goods goods = new Goods("Цемент", 5300, 1000, 30000, "");
        Order order = new Order(deliveryFromTo, goods);
        System.out.println(order.getPrice());
    }
}
