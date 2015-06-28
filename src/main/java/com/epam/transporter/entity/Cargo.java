package com.epam.transporter.entity;

public class Cargo {

    private String name;
    private Integer weight;
    private Integer volume;
    private Integer cost;
    private String comment;

    public Cargo(String name, int weight, int volume, int cost, String comment) {
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

    public void setWeight(int weight) {
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
