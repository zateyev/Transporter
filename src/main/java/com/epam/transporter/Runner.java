package com.epam.transporter;

import com.epam.transporter.entity.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
        System.out.println(deliveryFromTo.getDistance());
        Goods goods = new Goods("Цемент", 1230, 1000, 30000, "");
        Order order = new Order(deliveryFromTo, goods);
        System.out.println(String.valueOf(order.getGoods().typeByWeight()));
        Locale locale = new Locale("kk", "KZ");
        ResourceBundle rb = ResourceBundle.getBundle("i18n", locale);
        System.out.println(rb.getString("key1"));
    }
}
