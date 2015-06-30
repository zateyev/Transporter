package com.epam.transporter.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GoodsType", propOrder = {
        "name",
        "weight",
        "volume",
        "cost",
        "comment"
})
public class Goods {
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private Integer weight;
    @XmlElement(required = true)
    private Integer volume;
    @XmlElement(required = true)
    private Integer cost;
    @XmlElement(required = true)
    private String comment;

    public Goods() {
    }

    public Goods(String name, int weight, int volume, int cost, String comment) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
