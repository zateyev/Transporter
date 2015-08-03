package com.epam.transporter.dao;

import com.epam.transporter.entity.Customer;

public interface CustomerDao {
    Customer findById(Long l);

    Customer findByEmail(String email);

    void update(Customer customer);

    Customer save(Customer customer);

    Customer merge(Customer customer);

    Customer insert(Customer customer);

    boolean remove(Customer customer);

    boolean removeById(long id);
}
