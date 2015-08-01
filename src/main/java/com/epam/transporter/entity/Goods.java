package com.epam.transporter.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goods", propOrder = {
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
    private long id;

    public Goods() {
    }

    public Weightiness typeByWeight() {
        if (this.weight>=200&&this.weight<1500) return Weightiness.VERY_LIGHT;
        else if (this.weight>=1500&&this.weight<3000) return Weightiness.LIGHT;
        else if (this.weight>=3000&&this.weight<5000) return Weightiness.MEDIUM;
        else if (this.weight>=5000&&this.weight<8000) return Weightiness.HEAVY;
        else if (this.weight>=8000&&this.weight<20000) return Weightiness.VERY_HEAVY;
        else return null;
    }

    public Goods(String name, Integer weight, Integer volume, Integer cost, String comment) {
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
