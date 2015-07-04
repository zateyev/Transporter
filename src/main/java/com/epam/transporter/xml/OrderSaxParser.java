package com.epam.transporter.xml;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

public class OrderSaxParser implements Parser {
    @Override
    public Order parseOrder(InputStream inputStream) {
        return null;
    }

    public static class OrderHandler extends DefaultHandler {
        private Order order = new Order();
        private DeliveryPoints deliveryPoints = new DeliveryPoints();
        private Goods goods = new Goods();
        private StringBuilder sb = new StringBuilder();
        private String element = "";

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
            switch (this.element) {
                case "deliveryPoints":
                    order.setDeliveryFromTo(deliveryPoints);
                    break;
                case "goods":
                    order.setGoods(goods);
                    break;
                case "strartingPoint":
                    deliveryPoints.setStartingPoint(sb.toString());
                    break;
                case "destination":
                    deliveryPoints.setDestination(sb.toString());
                    break;
                case "name":
                    goods.setName(sb.toString());
                    break;
                case "weight":
                    goods.setWeight(new Integer(sb.toString()));
                    break;
                case "volume":
                    goods.setVolume(new Integer(sb.toString()));
                    break;
                case "cost":
                    goods.setCost(new Integer(sb.toString()));
                    break;
                case "comment":
                    goods.setComment(sb.toString());
                    break;
            }
            element = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length).trim();
            sb.append(str);
        }
    }
}
