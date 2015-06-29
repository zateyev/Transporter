package com.epam.transporter.logic;

import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPars extends DefaultHandler {
    private Order order = new Order();
    private DeliveryPoints deliveryPoints;
    private Goods goods;
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
        if (this.element.equals("DeliveryPoints")) {
            order.setDeliveryFromTo(deliveryPoints);
        }
        if (this.element.equals("Goods")) {
            order.setGoods(goods);
        }
        element = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.element.equals("DeliveryPoints")) {
            deliveryPoints = new DeliveryPoints();
        }
        if (this.element.equals("strartingPoint")) {
            deliveryPoints.setStartingPoint(new String(ch, start, length));
        }
        if (this.element.equals("destination")) {
            deliveryPoints.setDestination(new String(ch, start, length));
        }
        if (this.element.equals("Goods")) {
            goods = new Goods();
        }
        if (this.element.equals("name")) {
            goods.setName(new String(ch, start, length));
        }
        if (this.element.equals("weight")) {
            goods.setWeight(new Integer(new String(ch, start, length)));
        }
        if (this.element.equals("volume")) {
            goods.setVolume(new Integer(new String(ch, start, length)));
        }
        if (this.element.equals("cost")) {
            goods.setCost(new Integer(new String(ch, start, length)));
        }
        if (this.element.equals("comment")) {
            goods.setComment(new String(ch, start, length));
        }
    }
}
