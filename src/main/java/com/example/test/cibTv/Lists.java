package com.example.test.cibTv;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {


    public static void main(String[] args) {

        String soapRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "  <version>1.0</version>\n" +
                "  <operation_envelope>\n" +
                "    <operation_xml>awerawerlkhWFEfdasfEWAFfdsafFEDFLksdj==</operation_xml>\n" +
                "    <signature>" + "sdfEFDfdsfd=" + "</signature>\n" +
                "  </operation_envelope>\n" +
                "</response>";


        String xml_data = "<response>\n" +
                "      <!--Original message-->\n" +
                "      <action>customers_list</action>\n" +
                "      <operator_id>6543</operator_id>\n" +
                "      <!--Server Response-->\n" +
                "      <status>\n" +
                "\tsuccess <!--Operation status: failure - error, success - success -->\n" +
                "      </status>\n" +
                "      <error></error><!--description of the error-->\n" +
                "      <customers>\n" +
                "          <customer>\n" +
                "            <id>434322</id>\n" +
                "            <first_name>Joe</first_name>\n" +
                "            <last_name>Shmoe</last_name>\n" +
                "            <email>joe.shmoe@gmail.com</email>\n" +
                "            <status>active</status>            \n" +
                "            <subscribed_till>2012-05-18</subscribed_till>\n" +
                "          </customer>\n" +
                "          <!-- Could be many customers -->\n" +
                "      </customers><!--if successefull-->\n" +
                "</response>";


        String xml_data1 = "<response>\n" +
                "      <!--Original message-->\n" +
                "      <action>balance</action>\n" +
                "      <amount>100</amount>\n" +
                "      <customer_id>23434</customer_id>\n" +
                "      <txn_id>payment_paynow_242FDA322125432</txn_id>\n" +
                "      <operator_id>6543</operator_id>      \n" +
                "      <!--Server Response-->\n" +
                "      <status>\n" +
                "\tsuccess <!--Operation status: failure - error, success - success -->\n" +
                "      </status>\n" +
                "      <error></error><!--description of the error-->\n" +
                "      <current_balance>200</current_balance><!-- if successefull-->      \n" +
                "</response>";

        XML_Data xmlData;

        try {
            xmlData = XMLHashedParser.parseXmlString(soapRequest);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//
//        if (xmlData.getChildByName("response").getChildByName("operation_envelope")
//                .getChildByName("signature").getValue().equals("sdfEFDfdsfd=")) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//
//        String subscriberName = xmlData.getChildByName("response").getChildByName("operation_envelope")
//                .getChildByName("signature").getValue();
//
//
//        System.out.println("Subc num: " + subscriberName);


        try {
            if (XMLHashedParser.parseXmlString(xml_data).getChildByName("response").getChildByName("status").getValue().equals("success")) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String xd;
        String xd1;
        String xd2;
        String xd3;

        try {
            xd = XMLHashedParser.parseXmlString(xml_data).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("id").getValue();
            xd1 = XMLHashedParser.parseXmlString(xml_data).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("first_name").getValue();
            xd2 = XMLHashedParser.parseXmlString(xml_data).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("last_name").getValue();
            xd3 = XMLHashedParser.parseXmlString(xml_data).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("address").getValue();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//
//        System.out.println("Custmer: " + xd);
//        System.out.println("Custmer 1: " + xd1);
//        System.out.println("Custmer 2: " + xd2);
//        System.out.println("Custmer 3: " + xd3);


        String axd;
        String axd1;
        String axd2;
        String axd3;

        try {
            axd = XMLHashedParser.parseXmlString(xml_data1).getChildByName("response").getChildByName("status").getValue();
//            axd1 = XMLHashedParser.parseXmlString(xml_data1).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("first_name").getValue();
//            axd2 = XMLHashedParser.parseXmlString(xml_data1).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("last_name").getValue();
//            axd3 = XMLHashedParser.parseXmlString(xml_data1).getChildByName("response").getChildByName("customers").getChildByName("customer").getChildByName("address").getValue();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Custmer: " + axd);
//        System.out.println("Custmer 1: " + axd1);
//        System.out.println("Custmer 2: " + axd2);
//        System.out.println("Custmer 3: " + axd3);

    }
}
