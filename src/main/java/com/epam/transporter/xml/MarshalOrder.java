package com.epam.transporter.xml;

import com.epam.transporter.logic.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalOrder {
    public void convertToXml(Order order) {
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(order, new FileOutputStream("D:/marshalledOrder.xml"));
            marshaller.marshal(order, System.out);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
