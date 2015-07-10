package com.epam.transporter;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.logic.Price;
import com.epam.transporter.xml.MarshalOrder;
import com.epam.transporter.xml.OrderSaxParser;
import org.apache.log4j.Logger;

import java.io.InputStream;

public class Runner {
    static Logger logger = Logger.getLogger(Runner.class);

    public static void main(String[] args) {

//        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//        URL xsdUrl = Runner.class.getClassLoader().getResource(args[0]);
//        URL xmlUrl = Runner.class.getClassLoader().getResource(args[1]);
//        InputStream xmlIn = Runner.class.getClassLoader().getResourceAsStream(args[1]);
//        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
//        try {
//            Schema schema = schemaFactory.newSchema(xsdUrl);
//            SAXParserFactory spf = SAXParserFactory.newInstance();
//            spf.setNamespaceAware(true);
//            spf.setSchema(schema);
//            SAXParser parser = spf.newSAXParser();
//            parser.parse(xmlIn, new TruckErrorHandler());
//            logger.info(xmlUrl + " file is valid");
//        } catch (SAXException | ParserConfigurationException | IOException e) {
//            logger.error(xmlUrl + " validation failed!", e);
//        }


//        DeliveryPoints deliveryFromTo = new DeliveryPoints("Астана", "Караганды");
//        System.out.println(deliveryFromTo.calculateDistance());
//        Goods goods = new Goods("Цемент", 5300, 1000, 30000, "");
//        Order order = new Order(deliveryFromTo, goods);

        OrderSaxParser orderSaxParser = new OrderSaxParser();
        InputStream xmlIn = Runner.class.getClassLoader().getResourceAsStream("order.xml");
        Order order = orderSaxParser.parseOrder(xmlIn);

        Price price = new Price(order);
        System.out.println(price.getPrice());
//        MarshalOrder marshalOrder = new MarshalOrder();
//        marshalOrder.convertToXml(order);
    }
}
