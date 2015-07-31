package com.epam.transporter.dao;

import com.epam.transporter.entity.DeliveryPoints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.transporter.dao.JdbcDaoFactory.createConnection;
import static com.epam.transporter.dao.JdbcDaoFactory.freeConnection;

public class JdbcDeliveryPointsDao implements DeliveryPointsDao {
    @Override
    public DeliveryPoints findByPoints(String startingPoint, String destination) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT DISTANCE FROM DISTANCE WHERE ID_POINT1 IN" +
                    "(SELECT ID FROM POINTS WHERE POINT=?) AND ID_POINT2 IN (SELECT ID FROM POINTS WHERE POINT=?)" +
                    "OR ID_POINT1 IN (SELECT ID FROM POINTS WHERE POINT=?) AND ID_POINT2 IN (SELECT ID FROM POINTS WHERE POINT=?)");
            preparedStatement.setString(1, startingPoint);
            preparedStatement.setString(2, destination);
            preparedStatement.setString(3, destination);
            preparedStatement.setString(4, startingPoint);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            DeliveryPoints deliveryPoints = new DeliveryPoints();
            deliveryPoints.setStartingPoint(startingPoint);
            deliveryPoints.setDestination(destination);
            deliveryPoints.setDistance(resultSet.getInt("DISTANCE"));
            return deliveryPoints;
        } catch (SQLException e) {
            throw new DaoException();
        }
        finally {
            freeConnection(connection);
        }
    }
}
