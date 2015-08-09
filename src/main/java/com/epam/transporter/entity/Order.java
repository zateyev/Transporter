package com.epam.transporter.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
        "deliveryPoints",
        "goods"
})
public class Order extends BaseEntity {
    @XmlElement(name = "deliveryPoints", required = true)
    private DeliveryPoints deliveryPoints;
    @XmlElement(name = "goods", required = true)
    private Goods goods;
    private Status status;
    private User user;

    public Order() {
    }

    public Order(DeliveryPoints deliveryPoints, Goods goods) {
        this.deliveryPoints = deliveryPoints;
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Truck getSuitableTruck() {
        Weightiness weightiness = goods.typeByWeight();
        return TrucksPark.getTruckByLoadCapacity(weightiness);
    }

    public DeliveryPoints getDeliveryPoints() {
        return deliveryPoints;
    }

    public void setDeliveryPoints(DeliveryPoints deliveryPoints) {
        this.deliveryPoints = deliveryPoints;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        NEW, IN_WORK, WORKED_OUT, CANCELED
    }
}
