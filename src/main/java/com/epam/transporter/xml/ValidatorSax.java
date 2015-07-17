package com.epam.transporter.xml;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ValidatorSax {
    Logger logger = Logger.getLogger(getClass());

    public void validate(String xsdFileName, String xmlFileName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        URL xsdUrl = getClass().getClassLoader().getResource(xsdFileName);
        URL xmlUrl = getClass().getClassLoader().getResource(xmlFileName);
        InputStream xmlIn = getClass().getClassLoader().getResourceAsStream(xmlFileName);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        try {
            Schema schema = schemaFactory.newSchema(xsdUrl);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(xmlIn, new TruckErrorHandler());
            logger.info(xmlUrl + " file is valid");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
