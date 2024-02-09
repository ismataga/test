package com.example.test.azeriqaz_smartcart;


import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlSender {

    public static boolean document() {
        String postData1 = "<ipayMsg client=\"iPay\" term=\"1\" seqNum=\"7\" time=\"2010-04-01 11:35:21 +0200\">\n" +
                "  <gen2wayMsg ver=\"1.0\" resource=\"gas\">\n" +
                "    <custInfoRes>\n" +
                "      <ref>a123</ref>\n" +  // Replace 'a123' with your actual 'a' value
                "      <res code=\"gen2way000\">OK</res>\n" +
                "      <customer>EVG Contract 2</customer>\n" +
                "    </custInfoRes>\n" +
                "  </gen2wayMsg>\n" +
                "</ipayMsg>";

        String soapRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "  <version>1.0</version>\n" +
                "  <operation_envelope>\n" +
                "    <operation_xml>awerawerlkhWFEfdasfEWAFfdsafFEDFLksdj==</operation_xml>\n" +
                "    <signature>" + "sdfEFDfdsfd=" + "</signature>\n" +
                "  </operation_envelope>\n" +
                "</response>";

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML string into a Document
            Document document = builder.parse(new InputSource(new StringReader(soapRequest)));

            // Now, you can work with the parsed XML document
            // For example, you can access elements and attributes like this:
            String refValue = document.getElementsByTagName("response").item(0).getTextContent();
            String resCode = document.getElementsByTagName("version").item(0).getTextContent();
            String customerValue = document.getElementsByTagName("operation_envelope").item(0).getTextContent();

            // Print the parsed values
            System.out.println("response: " + refValue);
            System.out.println("version: " + resCode);
            System.out.println("operation_envelope: " + customerValue);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


    public static void main(String[] args) {

        System.out.println(document());

    }
}





