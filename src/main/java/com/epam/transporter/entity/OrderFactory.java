package com.epam.transporter.entity;


import com.epam.transporter.logic.Order;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

public class OrderFactory {
    private final static QName _Order_QNAME = new QName("", "Order");

    public OrderFactory() {
    }

    public Order createOrderType() {
        return new Order();
    }

    public Goods createGoodsType() {
        return new Goods();
    }

    public DeliveryPoints createDeliveryPointsType() {
        return new DeliveryPoints();
    }

    @XmlElementDecl(namespace = "", name = "Order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }
}
