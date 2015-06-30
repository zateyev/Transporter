package com.epam.transporter.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.*;
import java.util.Properties;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryPointsType", propOrder = {
        "strartingPoint",
        "destination"
})
public class DeliveryPoints {
    @XmlElement(required = true)
    private String startingPoint;
    @XmlElement(required = true)
    private String destination;
    private int distance;

    public DeliveryPoints() {
    }

    public DeliveryPoints(String startingPoint, String destination) {
        this.startingPoint = startingPoint;
        this.destination = destination;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public int calculateDistance() {
        String url = "jdbc:mysql://localhost:3306/transporter";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "1111");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        Connection cn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(url, prop);
            Statement st = null;
            try {
                st = cn.createStatement();
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("select distance from distance where id_city1 in" +
                            "(select id_city from cities where city='" + startingPoint + "')\n" +
                            "and id_city2 in (select id_city from cities where city='" + destination + "')\n" +
                            "or id_city1 in (select id_city from cities where city='" + destination + "')\n" +
                            "and id_city2 in (select id_city from cities where city='" + startingPoint + "')");
                    while (rs.next()) {
                        distance = rs.getInt(1);
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    } else {
                        System.err.println(
                                "ошибка во время чтения из БД");
                    }
                }
            } finally {
                if (st != null) {
                    st.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Connection close error: " + e);
                }
            }
        }
        return distance;
    }
}