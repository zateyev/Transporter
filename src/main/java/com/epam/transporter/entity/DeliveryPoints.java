package com.epam.transporter.entity;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.DeliveryPointsDao;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deliveryPoints", propOrder = {
        "startingPoint",
        "destination"
})
public class DeliveryPoints {
    @XmlElement(required = true)
    private String startingPoint;
    @XmlElement(required = true)
    private String destination;
    @XmlTransient
    private int distance;

    public DeliveryPoints() {
    }

    public DeliveryPoints(String startingPoint, String destination) {
        this.startingPoint = startingPoint;
        this.destination = destination;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        if (distance!=0) return distance;
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        DeliveryPointsDao jdbcDeliveryPointsDao = jdbcDaoFactory.getDeliveryPointsDao();
        DeliveryPoints deliveryPoints = jdbcDeliveryPointsDao.findByPoints(startingPoint, destination);
        return deliveryPoints.getDistance();
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}