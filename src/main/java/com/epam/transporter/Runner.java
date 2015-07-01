package com.epam.transporter;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.logic.Price;
import com.epam.transporter.xml.SAXPars;
import com.epam.transporter.xml.TruckErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Runner {

    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "C:\\Users\\Жасулан\\IdeaProjects\\Transporter\\src\\main\\resources\\trucks.xml";
        String schemaName = "C:\\Users\\Жасулан\\IdeaProjects\\Transporter\\src\\main\\resources\\trucks.xsd";
        String logName = "D:\\log.txt";
        Schema schema;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(fileName, new TruckErrorHandler(logName));
            System.out.println(fileName + " is valid");
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
//        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
//        System.out.println(deliveryFromTo.calculateDistance());
//        Goods goods = new Goods("Цемент", 5300, 1000, 30000, "");
//        Order order = new Order(deliveryFromTo, goods);

//        SAXParserFactory parserF = SAXParserFactory.newInstance();
//        SAXPars saxPars = new SAXPars();
//        try {
//            SAXParser parser = parserF.newSAXParser();
//            parser.parse(new File("D:\\order.xml"), saxPars);
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
//        Order order = saxPars.getOrder();
//
//        Price price = new Price(order);
//        System.out.println(price.getPrice());
    }
}
