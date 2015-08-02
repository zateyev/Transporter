package com.epam.transporter;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.CustomerManager;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.entity.Order;
import com.epam.transporter.logic.Price;

public class Runner {

    public static void main(String[] args) {
        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
        System.out.println(deliveryFromTo.getDistance());
        Goods goods = new Goods("Цемент", 1230, 1000, 30000, "");
        Order order = new Order(deliveryFromTo, goods);

        /*OrderSaxParser orderSaxParser = new OrderSaxParser();
        InputStream xmlIn = Runner.class.getClassLoader().getResourceAsStream("order.xml");
        Order order = orderSaxParser.parseOrder(xmlIn);*/

        Price price = new Price(order);
        System.out.println(price.getPrice());
//        MarshalOrder marshalOrder = new MarshalOrder();
//        marshalOrder.convertToXml(order);

        Customer customer = new CustomerManager().findCustomerByEmail("zhasulan@mail.com");
        System.out.println(customer.getPassword());

        System.out.println(String.valueOf(order.getGoods().typeByWeight()));
    }
}
