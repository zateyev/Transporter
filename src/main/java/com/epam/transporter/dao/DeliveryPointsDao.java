package com.epam.transporter.dao;

import com.epam.transporter.entity.DeliveryPoints;

public interface DeliveryPointsDao {
    DeliveryPoints findByPoints(String startingPoint, String destination);
    Long getIdByPoint(String pointName);
}
