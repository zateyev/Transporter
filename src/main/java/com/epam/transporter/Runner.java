package com.epam.transporter;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.CustomerManager;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.entity.Order;
import com.epam.transporter.logic.Reservation;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

    public static void main(String[] args) {
        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
        System.out.println(deliveryFromTo.getDistance());
        Goods goods = new Goods("Цемент", 1230, 1000, 30000, "");
        Order order = new Order(deliveryFromTo, goods);

        /*OrderSaxParser orderSaxParser = new OrderSaxParser();
        InputStream xmlIn = Runner.class.getClassLoader().getResourceAsStream("order.xml");
        Order order = orderSaxParser.parseOrder(xmlIn);*/

        Reservation.reserveTruck(order.getSuitableTruck());
        System.out.println(order.getPrice());
//        MarshalOrder marshalOrder = new MarshalOrder();
//        marshalOrder.convertToXml(order);

        Customer customer = new CustomerManager().findCustomerByEmail("zhasulan@mail.com");
        System.out.println(customer.getPassword());

        System.out.println(String.valueOf(order.getGoods().typeByWeight()));

        Locale locale = new Locale("kk", "KZ");
        ResourceBundle rb = ResourceBundle.getBundle("i18n", locale);
        System.out.println(rb.getString("key1"));
    }
}
