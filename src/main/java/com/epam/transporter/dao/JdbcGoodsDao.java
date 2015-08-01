package com.epam.transporter.dao;

import com.epam.transporter.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.transporter.dao.JdbcDaoFactory.createConnection;

public class JdbcGoodsDao implements GoodsDao {
    @Override
    public Goods findById(long id) {
        return null;
    }

    @Override
    public Goods findByName(String name) {
        return null;
    }

    @Override
    public Goods insert(Goods goods) {
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO GOODS (ID, NAME, WEIGHT, VOLUME, COST, COMMENT) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, goods.getName());
            preparedStatement.setInt(2, goods.getWeight());
            preparedStatement.setInt(3, goods.getVolume());
            preparedStatement.setInt(4, goods.getCost());
            preparedStatement.setString(5, goods.getComment());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            goods.setId(id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return goods;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }
}
