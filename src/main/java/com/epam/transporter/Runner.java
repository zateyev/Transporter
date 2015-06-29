package com.epam.transporter;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.logic.Price;
import com.epam.transporter.logic.SAXPars;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
//        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
//        System.out.println(deliveryFromTo.calculateDistance());
//        Goods goods = new Goods("Цемент", 5300, 1000, 30000, "");
//        Order order = new Order(deliveryFromTo, goods);

        SAXParserFactory parserF = SAXParserFactory.newInstance();
        SAXPars saxPars = new SAXPars();
        try {
            SAXParser parser = parserF.newSAXParser();
            parser.parse(new File("D:\\order.xml"), saxPars);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        Order order = saxPars.getOrder();

        Price price = new Price(order);
        System.out.println(price.getPrice());
    }
}
