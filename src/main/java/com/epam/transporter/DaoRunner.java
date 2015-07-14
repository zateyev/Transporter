package com.epam.transporter;

import com.epam.transporter.dao.CustomerDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.Customer;

public class DaoRunner {
    public static void main(String[] args) {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        CustomerDao jdbcCustomerDao = jdbcDaoFactory.getCustomerDao();
        Customer customer = jdbcCustomerDao.findById(1L);
        jdbcCustomerDao.update(customer);
        jdbcCustomerDao.save(customer);
        jdbcCustomerDao.merge(customer);
        jdbcCustomerDao.insert(customer);
        jdbcCustomerDao.remove(customer);
        jdbcCustomerDao.removeById(1L);
    }
}
