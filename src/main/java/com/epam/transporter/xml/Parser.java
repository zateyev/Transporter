package com.epam.transporter.xml;

import com.epam.transporter.logic.Order;

import java.io.InputStream;

public interface Parser {
    Order parseOrder(InputStream inputStream);
}
