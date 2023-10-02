package com.example.test.azeriqaz_smartcart;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Lists {



    public static void main(String[] args) {

        String xml_data1 = "<ipayMsg client=\"iPay\" term=\"1\" seqNum=\"7\" time=\"2010-04-01 11:35:21 +0200\">\n" +
                "<gen2wayMsg ver='1.0' resource='gas'>" +
                "<vendRes>" +
                "<ref>" + "sessionId" + "</ref>" +
                "<talexusToken serialNum='" + "cardNumber" + "' resourceType='gas' tokenType='smartCard'>" +
                "<tokenFile>" + "token1" + "</tokenFile>" +
                "<tokenFile>" + "token2" + "</tokenFile>" +
                "<tokenFile>" + "token3" + "</tokenFile>" +
                "<tokenFile>" + "token4" + "</tokenFile>" +
                "</talexusToken>" +
                "</vendRes>" +
                "</gen2wayMsg>" +
                "</ipayMsg>";


        String xml_data = "<ipayMsg client=\"iPay\" term=\"1\" seqNum=\"7\" time=\"2010-04-01 11:35:21 +0200\">\n" +
                "<gen2wayMsg ver=\"1.0\" resource=\"gas\">\n" +
                "<custInfoRes>\n" +
                "<ref>514514020028</ref>\n" +
                "<res code=\"gen2way000\">OK</res>\n" +
                "<customer>EVG Contract 2</customer>\n" +
                "</custInfoRes>\n" +
                "</gen2wayMsg>\n" +
                "</ipayMsg>";





        XML_Data xmlData ;

        try {
            xmlData = XMLHashedParser.parseXmlString(xml_data);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


      if(xmlData.getChildByName("ipayMsg").getChildByName("gen2wayMsg")
                .getChildByName("custInfoRes").getChildByName("res").getValue().equals("OK")){
          System.out.println("true");
      }else {
          System.out.println("false");
      }

        String subscriberName = xmlData.getChildByName("ipayMsg").getChildByName("gen2wayMsg").getChildByName("custInfoRes")
                .getChildByName("customer")
                .getValue();


        try {
            xmlData = XMLHashedParser.parseXmlString(xml_data1);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XML_Data[] talexusTokens = xmlData.getChildByName("ipayMsg").getChildByName("gen2wayMsg")
                .getChildByName("vendRes").getChildByName("talexusToken").getChilds();

        List<String> tokens = Arrays.stream(talexusTokens)
                .map(XML_Data::getValue)
                .collect(Collectors.toList());

        tokens.forEach(System.out::println);
        System.out.println("Custmer: "+subscriberName);

    }
}
