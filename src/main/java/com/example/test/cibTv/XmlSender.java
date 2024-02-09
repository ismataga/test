package com.example.test.cibTv;


import static com.example.test.cibTv.XMLHashedParser.parseXmlString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class XmlSender {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        getListRestorePayment();
//        getlist();
//        getXmlData();
//        getXmlDatas();
//        getCheck();
//        checkTransactionResponse();
//        lastPayment();
//        checkTransaction();

        getToken();
//        lastPayments();

//        checkTransactionResponsea();
    }
    private static void getToken() throws ParserConfigurationException, IOException, SAXException {
        String token = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<S:Body>" +
                "<ns2:loginResponse xmlns:ns2=\"http://payment.socar.az/\">" +
                "<return>200</return>" +
                "<return>eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IkdPTERFTlBBWV9VU0VSIiwianRpIjoiMjc0YjVlYTMtODNkMS00MjJmLTk3N2ItZDIyODNmOWZmNDYzIiwiZXhwIjoxNzA3MzkzNTUxfQ.7c9_aL9hx9_NDHk_XKZaLLCWBtOHLST0P68b7GH7h94</return>" +
                "</ns2:loginResponse>" +
                "</S:Body>" +
                "</S:Envelope>\n";
        String result = parseXmlString(token).getChildByName("S:Envelope").getChildByName("S:Body")
                .getChildByName("ns2:loginResponse").getChildByName("return", 2).getValue();
        System.out.println(result);


//        XML_Data[] getList = result.getChilds();
//        List<String> returns = new ArrayList<>();//"pay().Session";

//        for (XML_Data x : getList) {
////            if (x.getAttributeByName("return").equals("200")) {
//                String getSessionIds = x.getAttributeByName("return");
//                returns.add(getSessionIds);
////            }
////        }
//        System.out.println();
//        System.out.println(returns.get(0));
//        System.out.println(returns.get(1));
    }

    private static void checkTransactionResponsea() throws ParserConfigurationException, IOException, SAXException {
        String response = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<S:Body>" +
                "<ns2:checkTranscationsResponse xmlns:ns2=\"http://payment.socar.az/\">" +
                "<return>/bYHfWZZjYnBfSOszo03Ej3h5tKO+7m6bhd/w3CD0Ee6ZDQNB8LqZTo91OKqyRd5k1oZgCCmLdAL7m9B5b540/qy8LBSS6eWHgnwcbTwrXMuW4RMpXihGj8nxOL/Js+a</return>" +
                "</ns2:checkTranscationsResponse>" +
                "</S:Body>" +
                "</S:Envelope>";
        String result = parseXmlString(response).getChildByName("S:Envelope").getChildByName("S:Body")
                .getChildByName("ns2:checkTranscationsResponse").getChildByName("return").getValue();
        System.out.println(result);
    }
    private static void lastPayments() throws ParserConfigurationException, IOException, SAXException {
        String lastpayment = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "<S:Body>\n" +
                "<ns2:lastPaymentsResponse xmlns:ns2=\"http://payment.socar.az/\">\n" +
                "<return>/bYHfWZZjYnBfSOszo03Ej3h5tKO+7m6bhd/w3CD0Ee6ZDQNB8LqZTo91OKqyRd5QBWBo8oqFX2aHSX173OeOqD1wsO8AkvHmPhzdnt39XeVX8m04QX8h8mRfcLOlIf6</return>\n" +
                "</ns2:lastPaymentsResponse>\n" +
                "</S:Body>\n" +
                "</S:Envelope>";
        String result = parseXmlString(lastpayment).getChildByName("S:Envelope").getChildByName("S:Body")
                .getChildByName("ns2:lastPaymentsResponse").getChildByName("return").getValue();
        System.out.println(result);

    }


    private static void checkTransaction() throws ParserConfigurationException, IOException, SAXException {
        String checkTransactionResponse =
                "<subs>\n" +
                        "<R suc=\"t\">278999</R>\n" +
                        "<R suc=\"f\">278888</R>\n" +
                        "<R suc=\"f\">223388</R>\n" +
                        "</subs>";


        XML_Data[] getList = parseXmlString(checkTransactionResponse).getChildByName("subs").getChilds();
        List<String> list = new ArrayList<>();


        for (XML_Data x : getList) {
            if (x.getAttributeByName("suc").equals("f")) {
                String getSessionIds = x.getValue();
                list.add(getSessionIds);
            }
        }
        System.out.println(list);

    }


    private static void lastPayment() throws ParserConfigurationException, IOException, SAXException {
        String payment = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<subs sno=\"005FBBF700250400\">\n" +
                "<payment>\n" +
                "<trno>95154656043</trno>\n" +
                "<amount>4.0</amount>\n" +
                "<time_completed>2020-04-04 15:45:44.423</time_completed>\n" +
                "<meter_num>GPG10063527</meter_num>\n" +
                "<client>YTHM000661701</client>\n" +
                "</payment>\n" +
                "<payment>\n" +
                "<trno>85154266178</trno>\n" +
                "<amount>5.0</amount><time_completed>2020-03-25 15:42:33.353</time_completed\n" +
                "><meter_num>GPG10063527</meter_num>\n" +
                "<client>YTHM000661701</client>\n" +
                "</payment>\n" +
                "<payment>\n" +
                "<trno>72151733230</trno>\n" +
                "<amount>5.0</amount>\n" +
                "<time_completed>2020-03-12 15:17:49.7</time_completed>\n" +
                "<meter_num>GPG10063527</meter_num>\n" +
                "<client>YTHM000661701</client>\n" +
                "</payment>\n" +
                "</subs>";

//        String xav = Arrays.toString(parseXmlString(payment).getChildByName("subs").getChildByName("payment").getChildByName("nested").getChilds());

        XML_Data[] getList = parseXmlString(payment).getChildByName("subs").getChilds();
        List<String> sessionIds = new ArrayList<>();//"pay().Session";

        for (XML_Data x : getList) {
            sessionIds.add(x.getChildByName("trno").getValue());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<subs type=\"2\">\n");
        sessionIds.forEach(sessionId -> sb.append("<R>").append(sessionId).append("</R>\n"));
        sb.append("</subs>");

        System.out.println(sb);
//        System.out.println(sessionIds.get(1));
//        System.out.println(sessionIds.get(2));

//        System.out.println(xav);

    }

    private static void getXmlDatas() throws ParserConfigurationException, IOException, SAXException {
        String postData = "<response>" +
                "<result code=\"0\" service=\"0\">" +
                "<data>" +
                "<input key=\"is-prepaid-payment\" keyTitle=\"is-prepaid-payment\" value=\"true\" valueTitle=\"true\"/>" +
                "<input key=\"id2\" keyTitle=\"id2\" value=\"pack\" valueTitle=\"pack\"/>" +
                "</data>" +
                "</result>" +
                "</response>";
//
//
        String az = "<response>" +
                "<result code=\"0\" service=\"0\">" +
                "<data>" +
                "<input key=\"is-billing\" keyTitle=\"is-billing\" value=\"true\" valueTitle=\"true\"/>" +
                "<input key=\"is-partial-payment\" keyTitle=\"is-partial-payment\" value=\"true\" valueTitle=\"true\"/>" +
                "<input key=\"id2\" keyTitle=\"id2\" value=\"alt\" valueTitle=\"alt\"/>" +
                "</data>" +
                "</result>" +
                "</response>\n";
//

        String a = "<response>" +
                "<result code=\"0\" service=\"0\">" +
                "<data>" +
                "<input key=\"is-partial-payment\" keyTitle=\"is-partial-payment\" value=\"true\" valueTitle=\"true\"/>" +
                "<input key=\"id2\" keyTitle=\"id2\" value=\"alt\" valueTitle=\"alt\"/>" +
                "</data>" +
                "</result>" +
                "</response>\n";

        XML_Data result = parseXmlString(postData).getChildByName("response").getChildByName("result");
        XML_Data[] dataList = result.getChildByName("data").getChilds();

        String type = null;
        for (XML_Data x : dataList) {
            if (x.getAttributeByName("key").equals("id2")) {
                type = x.getAttributeByName("value");
            }
        }
        System.out.println(type);


//        XML_Data result = parseXmlString(postData).getChildByName("response").getChildByName("result");
//        String result1 = result.getChildByName("data").getChildByName("input", 2).getAttributeByName("value");


//        String value = result.getChildByName("response")
//                .getChildByName("result")
//                .getChildByName("data").getChildByName("input", 2).getAttributeByName("value");
//        System.out.println(result1);

    }


    private static void checkTransactionResponse() throws ParserConfigurationException, IOException, SAXException {
        String xml = "<subs type=\"2\">\n" +
                "<R>sessionid</R>\n" +
                "</subs>";
        String checkTransaction = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<subs>\n" +
                "<R suc=\"t\">278999</R>\n" +
                "</subs>";
        XML_Data xmlData = parseXmlString(checkTransaction);
        XML_Data xmls = parseXmlString(xml);
        String result = xmlData.getChildByName("subs").getChildByName("R", 1).getAttributeByName("suc");
        String getSessionId = xmlData.getChildByName("subs").getChildByName("R", 1).getValue();
        String SessionId = xmls.getChildByName("subs").getChildByName("R").getValue();
        System.out.println(result);
        System.out.println(SessionId);


    }


    private static void getCheck() throws ParserConfigurationException, IOException, SAXException {

        String restorePayment = "<ipayMsg client=\"iPay\" term=\"1\" seqNum=\"7\" time=\"2010-04-01 11:36:21 +0200\">\n" +
                "<gen2wayMsg ver=\"1.0\" resource=\"gas\">\n" +
                "<vendLastRes>\n" +
                "<ref>514514020028</ref>\n" +
                "<res code=\"gen2way000\">OK</res>\n" +
                "<vendRes>\n" +
                "<ref>020000000028</ref>\n" +
                "<res code=\"gen2way000\">OK</res>\n" +
                "<amt>2000</amt>\n" +
                "<tax>0</tax>\n" +
                "<units>200.0</units>\n" +
                "<talexusToken serialNum=\"0055e90f00250400\" resourceType=\"gas\"\n" +
                "tokenType=\"SmartCard\">\n" +
                "<tokenFile>0000e4592825173b000000000000</tokenFile>\n" +
                "<tokenFile>853c5efff55c0000eb36b34b540001016200380005019a0006000102a00004000103a4000\n" +
                "e000203b2001c000303ce0024000104f20006002b04f80006001104fe0004001b04020100002c0402010\n" +
                "200040404010200050406010400ffff0a010000000000000000000000000000000000000000000045564\n" +
                "7434f4e32000000000000000000000000002a050000475047313033373330363301000000000000c8000\n" +
                "00080436d380101e80300010101010100000000010000000000000000000000000000000000000000000\n" +
                "00001010101c007000000000000000000000000000000000000000000000000000000000100000000000\n" +
                "10080436d3864006400fe000000e80300000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "00000000000</tokenFile>\n" +
                "<tokenFile>8a6c65754d9c0000eb36b34b0c0002021a000400ffff1e000000c80000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "00000000000</tokenFile>\n" +
                "<tokenFile>1134568dcde40000eb36b34b0000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                "000000000000000000000000000000000000000</tokenFile>\n" +
                "</talexusToken>\n" +
                "<meterNum>GPG10373063</meterNum>\n" +
                "<rctNum>EVGCGGN0000000010</rctNum>\n" +
                "<customer>EVG Contract 2</customer>\n" +
                "<util>Western Region</util>\n" +
                "<tariff>EVG Tariff 2</tariff>\n" +
                "</vendRes>\n" +
                "</vendLastRes>\n" +
                "</gen2wayMsg>\n" +
                "</ipayMsg>";
        XML_Data xmlData = parseXmlString(restorePayment);

        String paymentDate = xmlData.getChildByName("ipayMsg").getAttributeByName("time");
        String paymentAmount = xmlData.getChildByName("ipayMsg").getChildByName("gen2wayMsg").getChildByName("vendLastRes").getChildByName("amt").getValue();

        XML_Data[] talexusTokens = xmlData.getChildByName("ipayMsg").getChildByName("gen2wayMsg")
                .getChildByName("vendLastRes").getChildByName("vendRes").getChildByName("talexusToken").getChilds();

        List<String> tokens = Arrays.stream(talexusTokens)
                .map(XML_Data::getValue)
                .toList();
//
//        System.out.println("Tokens:");
//        tokens.forEach(System.out::println);

//        "paymentDate", names.substring(0, 10)));
//        "paymentAmount", String.valueOf(recoveryAmount)));
//        "nfcCardData", "data-to-card"));


//        List<String> ad = new ArrayList<>();
        System.out.println("paymentAmount " + paymentAmount);
        System.out.println("paymentDate " + paymentDate.substring(0, 10));
        System.out.println("cardType " + tokens.get(0));
        System.out.println("in " + tokens.get(1));
        System.out.println("out " + tokens.get(2));
        System.out.println("extra " + tokens.get(3));
//


//        System.out.println("checkStatus ");
    }


    private static void getXmlData() throws ParserConfigurationException, IOException, SAXException {
        String restoreResponse = "\n" +
                "<response>\n" +
                "    <result code=\"0\" service=\"0\">\n" +
                "        <data>\n" +
                "            <input key=\"data-to-card\" keyTitle=\"New card data\" value=\"0056D20A49746578742F706C61696E7B2254223A223234333733353238303138343636363130333838222C22534E223A223231373437313937222C2275736572436F6465223A22303430303038343032303130303337227D\" valueTitle=\"0056D20A49746578742F706C61696E7B2254223A223234333733353238303138343636363130333838222C22534E223A223231373437313937222C2275736572436F6465223A22303430303038343032303130303337227D\"/>\n" +
                "        </data>\n" +
                "    </result>\n" +
                "</response>";

        XML_Data xmlData = parseXmlString(restoreResponse);
        String code = xmlData.getChildByName("response").getChildByName("result").getAttributeByName("code");
        String service = xmlData.getChildByName("response").getChildByName("result").getAttributeByName("service");

        if (code.equals("0") && service.equals("0")) {

            String cardData = xmlData.getChildByName("response").getChildByName("result").getChildByName("data").getChildByName("input")
                    .getAttributeByName("value");
            System.out.println(cardData);
        }
    }

    private static void getListRestorePayment() throws ParserConfigurationException, IOException, SAXException {

        String checkResponse = "<response>\n" +
                "    <result code=\"0\" service=\"0\">\n" +
                "        <data>\n" +
                "            <input key=\"sub-id\" keyTitle=\"Subscriber ID\" value=\"010000000001111\" valueTitle=\"010000000001111\"/>\n" +
                "            <input key=\"id1\" keyTitle=\"Meter ID\" value=\"21747423\" valueTitle=\"21747423\"/>\n" +
                "            <input key=\"sub-type\" keyTitle=\"Subscriber Type\" value=\"1\" valueTitle=\"1\"/>\n" +
                "            <input key=\"name\" keyTitle=\"Subscriber name\" value=\"TEST KO1\" valueTitle=\"TEST KO1\"/>\n" +
                "            <input key=\"surname\" keyTitle=\"Subscriber surname\" value=\"TEST K\" valueTitle=\"TEST K\"/>\n" +
                "            <input key=\"father\" keyTitle=\"Subscriber father&apos;s name\" value=\"Adil&#601; q&#601;z&#601;\" valueTitle=\"Adil&#601; q&#601;z&#601;\"/>\n" +
                "            <input key=\"debt\" keyTitle=\"Debt\" value=\"-1870.62\" valueTitle=\"-1870.62\"/>\n" +
                "            <input key=\"debt-percent\" keyTitle=\"Debt percent\" value=\"50.0\" valueTitle=\"50.0\"/>\n" +
                "            <input key=\"card-loaded\" keyTitle=\"card-loaded\" value=\"Card loaded\" valueTitle=\"Card loaded\"/>\n" +
                "        </data>\n" +
                "    </result>\n" +
                "</response>";

        XML_Data xd = parseXmlString(checkResponse).getChildByName("response").getChildByName("result").getChildByName("data");
        XML_Data xds = parseXmlString(checkResponse).getChildByName("response").getChildByName("result");

        if ((xds.getAttributeByName("code").equals("0")) && (xds).getAttributeByName("service").equals("0")) {
            String id1 = xd.getChildByName("input", 2).getAttributeByName("key");
            String idValue = xd.getChildByName("input", 2).getAttributeByName("value");
            String subId = xd.getChildByName("input", 1).getAttributeByName("key");
            String subIdValue = xd.getChildByName("input", 1).getAttributeByName("value");
            String subType = xd.getChildByName("input", 3).getAttributeByName("key");
            String subTypeValue = xd.getChildByName("input", 3).getAttributeByName("value");
            System.out.println(id1);
            System.out.println(idValue);
            System.out.println(subId);
            System.out.println(subIdValue);
            System.out.println(subType);
            System.out.println(subTypeValue);
        }
    }


    private static void getlist() throws ParserConfigurationException, IOException, SAXException {
        String a = "<response>\n" +
                "    <result code=\"0\" service=\"0\">\n" +
                "        <data>\n" +
                "            <nested id=\"#restore-payments\">\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"391974\" valueTitle=\"391974\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"0.0\" valueTitle=\"0.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"0.0\" valueTitle=\"0.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-26T11:57:53.0003665\" valueTitle=\"2023-12-26T11:57:53.0003665\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"390302\" valueTitle=\"390302\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-25T16:22:36.3962585\" valueTitle=\"2023-12-25T16:22:36.3962585\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"389853\" valueTitle=\"389853\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-25T12:56:31.2200813\" valueTitle=\"2023-12-25T12:56:31.2200813\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"389681\" valueTitle=\"389681\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-25T11:34:19.4580726\" valueTitle=\"2023-12-25T11:34:19.4580726\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383170\" valueTitle=\"383170\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:21:00.1544842\" valueTitle=\"2023-12-22T11:21:00.1544842\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383167\" valueTitle=\"383167\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:20:47.3729944\" valueTitle=\"2023-12-22T11:20:47.3729944\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383162\" valueTitle=\"383162\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:17:15.509683\" valueTitle=\"2023-12-22T11:17:15.509683\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383134\" valueTitle=\"383134\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:05:32.5194925\" valueTitle=\"2023-12-22T11:05:32.5194925\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383131\" valueTitle=\"383131\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:05:05.5257835\" valueTitle=\"2023-12-22T11:05:05.5257835\"/>\n" +
                "                </data>\n" +
                "                <data>\n" +
                "                    <input key=\"ext-id\" keyTitle=\"Unique ID\" value=\"383120\" valueTitle=\"383120\"/>\n" +
                "                    <input key=\"total-amount\" keyTitle=\"Total amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"charged-amount\" keyTitle=\"Charged amount\" value=\"1.0\" valueTitle=\"1.0\"/>\n" +
                "                    <input key=\"created-date\" keyTitle=\"Payment date\" value=\"2023-12-22T11:00:04.1687428\" valueTitle=\"2023-12-22T11:00:04.1687428\"/>\n" +
                "                </data>\n" +
                "            </nested>\n" +
                "        </data>\n" +
                "    </result>\n" +
                "</response>";

//        XML_Data []  xd = XMLHashedParser.parseXmlString(a).getChildByName("response").getChildByName("result")
//                .getChildByName("data")
//                .getChildByName("nested").getChilds();
//
//      String aaa = xd[0].getChildByName("input",1).getAttributeByName("value");
//        System.out.println(aaa);
        XML_Data[] getList = parseXmlString(a).getChildByName("response").getChildByName("result")
                .getChildByName("data").getChildByName("nested").getChilds();
        String key = null;
        String value = null;
        Integer amount = null;
        String names = null;
        for (XML_Data restorePayment : getList) {

            key = restorePayment.getChildByName("input", 1).getAttributeByName("key");
            value = restorePayment.getChildByName("input", 1).getAttributeByName("value");
            amount = Integer.valueOf(restorePayment.getChildByName("input", 3).getAttributeByName("value"));
            names = restorePayment.getChildByName("input", 4).getAttributeByName("value");

        }
        System.out.println(key);
        System.out.println(value);
        System.out.println(amount);
        System.out.println("Mpay: " + names.substring(0, 10));
//        XML_Data xds = XMLHashedParser.parseXmlString(a).getChildByName("response").getChildByName("result");


//        List<String> extIds = new ArrayList<>();
//        for ( String recoveryPayment: xd) {
//
//
//
////            for (XML_Data input : data.getChildsAsArray("input")) {
////                if (input.getAttributeByName("key").equals("ext-id")) {
////                    String value = input.getAttributeByName("value");
////                    extIds.add(value);
////                }
////            }
//        }

//        System.out.println(extIds);
//
//        if ((xds.getAttributeByName("code").equals("0")) && (xds).getAttributeByName("service").equals("0")) {
//            String id1 = xd.getChildByName("input", 2).getAttributeByName("key");
//            String idValue = xd.getChildByName("input", 2).getAttributeByName("value");
//            String subId = xd.getChildByName("input", 1).getAttributeByName("key");
//            String subIdValue = xd.getChildByName("input", 1).getAttributeByName("value");
//            String subType = xd.getChildByName("input", 3).getAttributeByName("key");
//            String subTypeValue = xd.getChildByName("input", 3).getAttributeByName("value");
//            System.out.println(id1);
//            System.out.println(idValue);
//            System.out.println(subId);
//            System.out.println(subIdValue);
//            System.out.println(subType);
//            System.out.println(subTypeValue);
//        }
    }

}






