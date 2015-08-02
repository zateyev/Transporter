package com.epam.transporter.xml;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.entity.Order;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class OrderSaxParser implements Parser {
    @Override
    public Order parseOrder(InputStream inputStream) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        Order order = null;
        try {
            saxParser = factory.newSAXParser();
            OrderHandler handler = new OrderHandler();
            saxParser.parse(inputStream, handler);
            order = handler.getOrder();
        } catch (ParserConfigurationException | SAXException | IOException ignored) {
        }
        return order;
    }

    public static class OrderHandler extends DefaultHandler {
        Method[] orderMethods = Order.class.getMethods();
        Method[] deliveryPointsMethods = DeliveryPoints.class.getMethods();
        Method[] goodsMethods = Goods.class.getMethods();
        private Map<String, String> currentElement = new HashMap<>();
        private Order order = new Order();
        private DeliveryPoints deliveryPoints = new DeliveryPoints();
        private Goods goods = new Goods();
        private StringBuilder sb = new StringBuilder();
        private String element = "";

        {
            currentElement.put("deliveryPoints", "setDeliveryPoints");
            currentElement.put("goods", "setGoods");
            currentElement.put("startingPoint", "setStartingPoint");
            currentElement.put("destination", "setDestination");
            currentElement.put("name", "setName");
            currentElement.put("weight", "setWeight");
            currentElement.put("volume", "setVolume");
            currentElement.put("cost", "setCost");
            currentElement.put("comment", "setComment");
        }

        public Order getOrder() {
            return order;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start parse XML...");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            for (Method method : deliveryPointsMethods) {
                if (currentElement.get(this.element).equals(method.getName())) {
                    try {
                        method.invoke(deliveryPoints, sb.toString());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (Method method : goodsMethods) {
                if (currentElement.get(this.element).equals(method.getName())) {
                    try {
                        method.invoke(goods, sb.toString());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (Method method : orderMethods) {
                if (currentElement.get(this.element).equals(method.getName())) {
                    try {
                        if (method.getName().equals("setDeliveryPoints")) method.invoke(order, deliveryPoints);
                        else method.invoke(order, goods);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
//            switch (this.element) {
//                case "deliveryPoints":
//                    order.setDeliveryPoints(deliveryPoints);
//                    break;
//                case "goods":
//                    order.setGoods(goods);
//                    break;
//                case "strartingPoint":
//                    deliveryPoints.setStartingPoint(sb.toString());
//                    break;
//                case "destination":
//                    deliveryPoints.setDestination(sb.toString());
//                    break;
//                case "name":
//                    goods.setName(sb.toString());
//                    break;
//                case "weight":
//                    goods.setWeight(new Integer(sb.toString()));
//                    break;
//                case "volume":
//                    goods.setVolume(new Integer(sb.toString()));
//                    break;
//                case "cost":
//                    goods.setCost(new Integer(sb.toString()));
//                    break;
//                case "comment":
//                    goods.setComment(sb.toString());
//                    break;
//            }
            //element = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length).trim();
            sb.append(str);
        }
    }
}
