package com.epam.transporter.dao;

import com.epam.transporter.entity.Truck;

import java.util.List;

public interface TruckDao {
    Truck findById(Long id);
    Truck findByModel(String model);
    Truck insert(Truck truck);
    boolean removeById(Long id);
    List<Truck> getTrucksList();
}
