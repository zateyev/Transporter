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
    private long id;

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

    public DeliveryPoints getDeliveryPoints() {
        return deliveryPoints;
    }

    public void setDeliveryPoints(DeliveryPoints deliveryPoints) {
        this.deliveryPoints = deliveryPoints;
    }

    public void setId(long id) {
        this.id = id;
    }
}
