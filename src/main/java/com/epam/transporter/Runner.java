package com.epam.transporter;

import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.entity.DeliveryPoints;
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
        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
        System.out.println(deliveryFromTo.calculateDistance());
        Goods goods = new Goods("Цемент", 5300, 1000, 30000, "");
        Order order = new Order(deliveryFromTo, goods);

//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = null;
//        try {
//            parser = factory.newSAXParser();
//        } catch (ParserConfigurationException | SAXException e) {
//            e.printStackTrace();
//        }
//        SAXPars saxp = new SAXPars();
//        try {
//            assert parser != null;
//            parser.parse(new File("D:\\order.xml"), saxp);
//        } catch (SAXException | IOException e) {
//            e.printStackTrace();
//        }

        Price price = new Price(order);
        System.out.println(price.getPrice());
    }
}
