package com.epam.transporter.dao;

import com.epam.transporter.entity.DeliveryPoints;

public interface DeliveryPointsDao {
    DeliveryPoints findByPoints(String startingPoint, String destination);
    DeliveryPoints findByPointsId(Long startingPointId, Long destinationId);
    Long getIdByPoint(String pointName);
    String getPointNameById(Long id);
}
