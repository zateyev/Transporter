package com.epam.transporter;

import com.epam.transporter.xml.TruckErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.net.URL;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();
        OutputStream outputStream = new FileOutputStream(new File("D:\\trucks.xml"));

        int read;
        byte[] bytes = new byte[1024];
        while ((read = fileContent.read(bytes)) != -1){
            outputStream.write(bytes, 0, read);
        }
        fileContent.close();
        outputStream.close();

        String xsdDescription = request.getParameter("xsd-description");
        Part xsdFilePart = request.getPart("xsd-file");
        String xsdFileName = xsdFilePart.getSubmittedFileName();
        InputStream xsdFileContent = xsdFilePart.getInputStream();
        OutputStream xsdOutputStream = new FileOutputStream(new File("D:\\trucks.xsd"));
        int read2;
        byte[] bytes2 = new byte[1024];
        while ((read2 = xsdFileContent.read(bytes2)) != -1){
            xsdOutputStream.write(bytes2, 0, read2);
        }
        xsdFileContent.close();
        xsdOutputStream.close();
    }
}
