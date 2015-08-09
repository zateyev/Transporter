package com.epam.transporter;

import com.epam.transporter.dao.UserDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.User;

public class DaoRunner {
    public static void main(String[] args) {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        UserDao jdbcUserDao = jdbcDaoFactory.getUserDao();
        User user = jdbcUserDao.findById(1L);
        jdbcUserDao.update(user);
        jdbcUserDao.save(user);
        jdbcUserDao.merge(user);
        jdbcUserDao.insert(user);
        jdbcUserDao.remove(user);
        jdbcUserDao.removeById(1L);
    }
}
