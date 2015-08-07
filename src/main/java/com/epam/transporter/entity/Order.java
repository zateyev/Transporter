package com.epam.transporter.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
        "deliveryPoints",
        "goods"
})
public class Order {
    @XmlElement(name = "deliveryPoints", required = true)
    private DeliveryPoints deliveryPoints;
    @XmlElement(name = "goods", required = true)
    private Goods goods;
    private Long id;
    private OrderStatus status;
    private Customer customer;

    public Order() {
    }

    public Order(DeliveryPoints deliveryPoints, Goods goods) {
        this.deliveryPoints = deliveryPoints;
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public Truck getSuitableTruck() {
        Weightiness weightiness = goods.typeByWeight();
        return TrucksPark.getTruckByLoadCapacity(weightiness);
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public DeliveryPoints getDeliveryPoints() {
        return deliveryPoints;
    }

    public void setDeliveryPoints(DeliveryPoints deliveryPoints) {
        this.deliveryPoints = deliveryPoints;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }
}
