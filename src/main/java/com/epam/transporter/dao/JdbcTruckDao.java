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
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO TRUCK (ID, MODEL, WEIGHT_CAPACITY, VOLUME_CAPACITY, PRICE_PER_KM, STATUS) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getCapacityByWeight());
            preparedStatement.setInt(3, truck.getCapacityByVolume());
            preparedStatement.setInt(4, truck.getPricePerKm());
            preparedStatement.setString(5, String.valueOf(truck.getStatus()));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            truck.setId(id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return truck;
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
                TruckStatus status = TruckStatus.valueOf(resultSet.getString("STATUS"));
                truckList.add(new Truck(trucksId, model, weightCapacity, volumeCapacity, pricePerKm, status));
            }
            return truckList;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            freeConnection(connection);
        }
    }

    @Override
    public void update(Truck truck) {
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE TRUCK SET STATUS = ? WHERE ID = ?");
            preparedStatement.setString(1, String.valueOf(truck.getStatus()));
            preparedStatement.setLong(2, truck.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
