package com.epam.transporter.dao;

import com.epam.transporter.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.transporter.dao.JdbcDaoFactory.createConnection;
import static com.epam.transporter.dao.JdbcDaoFactory.freeConnection;

public class JdbcTruckDao implements TruckDao {
    @Override
    public Truck findById(Long id) {
        return null;
    }

    @Override
    public Truck findByModel(String model) {
        return null;
    }

    @Override
    public Truck insert(Truck truck) {
        return null;
    }

    @Override
    public boolean removeById(Long id) {
        return false;
    }

    @Override
    public List<Truck> getTrucksList() {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, MODEL, WEIGHT_CAPACITY, VOLUME_CAPACITY, PRICE_PER_KM, STATUS FROM TRUCK");
            resultSet = preparedStatement.executeQuery();
            List<Truck> truckList = new ArrayList<>();
            while (resultSet.next()) {
                Long trucksId = resultSet.getLong("ID");
                String model = resultSet.getString("MODEL");
                Integer weightCapacity = resultSet.getInt("WEIGHT_CAPACITY");
                Integer volumeCapacity = resultSet.getInt("VOLUME_CAPACITY");
                Integer pricePerKm = resultSet.getInt("PRICE_PER_KM");
                String status = resultSet.getString("STATUS");
                truckList.add(new TruckBuilder()
                .id(trucksId)
                .model(model)
                .capacityByWeight(weightCapacity)
                .capacityByVolume(volumeCapacity)
                .pricePerKm(pricePerKm)
                .status(status)
                .build());
            }
            return truckList;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            freeConnection(connection);
        }
    }
}
