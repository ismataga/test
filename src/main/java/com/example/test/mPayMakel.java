//package com.example.test;
//
//import com.example.test.azeriqaz_smartcart.XMLHashedParser;
//import com.example.test.azeriqaz_smartcart.XML_Data;
//import java.io.IOException;
//import javax.xml.parsers.ParserConfigurationException;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.xml.sax.SAXException;
//
//public class mPayMakel {
//    private String firstAction(String response, RestTemplate restTemplate, HttpHeaders headers, String cardData) {
//        String actionResponse = null;
//
//        try {
//            XML_Data xd = XMLHashedParser.parseXmlString(response);
//
//            if (xd.getChildByName("root").getChildByName("code").getValue().equals("SUCCESS_EXIST_NEXT")) {
//                String session = xd.getChildByName("root").getChildByName("session").getValue();
//                XML_Data[] xmlData = xd.getChildByName("root").getChildByName("session").getChildByName("fields").getChilds();
//                String code = xmlData[0].getChildByName("code").getValue();
//                String value = xmlData[0].getChildByName("value").getValue();
//
//                String checkActionRequest = "<root>\n" +
//                        "    <action>next</action>\n" +
//                        "    <fields>\n" +
//                        "        <item>\n" +
//                        "            <code>" + pluginConfig.getCardData() + "</code>\n" +
//                        "         <value>" + cardData + "</value>\n" +
//                        "        </item>\n" +
//                        "    </fields>\n" +
//                        "     <session>" + session + "</session>\n" +
//                        "    <totalFeeSum>0</totalFeeSum>\n" +
//                        "    <totalPurchaseSum>0</totalPurchaseSum>\n" +
//                        "</root>\n";
//
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " firstAction().checkFirstActionRequest  body : " + checkActionRequest);
//                }
//
//                headers.setContentType(MediaType.TEXT_XML);
//                HttpEntity<String> httpEntity = new HttpEntity<>(checkActionRequest, headers);
//
//                String uri = pluginConfig.getUrl() + "/action";
//
//                ResponseEntity<String> response1 = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
//                actionResponse = response1.getBody();
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " firstAction().checkFirstActionResponse : " + actionResponse);
//                }
//                return actionResponse;
//
//            }
//        } catch (ParserConfigurationException | IOException | SAXException | MPayException e) {
//            e.printStackTrace();
//            LOGGER.error(BillingMPay.logPrefix + "Error occurred while checking firstAction request ", e);
//        }
//        return actionResponse;
//    }
//
//    String secondAction(String response, RestTemplate restTemplate, HttpHeaders headers) {
//        String actionResponse = null;
//
//        try {
//            XML_Data xd = XMLHashedParser.parseXmlString(response);
//
//            if (xd.getChildByName("root").getChildByName("code").getValue().equals("SUCCESS_EXIST_NEXT")) {
//                String session = xd.getChildByName("root").getChildByName("session").getValue();
//                XML_Data[] xmlData = xd.getChildByName("root").getChildByName("fields").getChilds();
//
//                String codeFullName = xmlData[0].getChildByName("code").getValue();
//                String valueFullName = xmlData[0].getChildByName("value").getValue();
//
//                String codeSubscriptionCode = xmlData[1].getChildByName("code").getValue();
//                String valueSubscriptionCode = xmlData[1].getChildByName("value").getValue();
//
//                String codeCounterNumber = xmlData[2].getChildByName("code").getValue();
//                String valueCounterNumber = xmlData[2].getChildByName("value").getValue();
//
//                String codeSubscribeType = xmlData[3].getChildByName("code").getValue();
//                String valueSubscribeType = xmlData[3].getChildByName("value").getValue();
//
//                String codeRemainingDebt = xmlData[4].getChildByName("code").getValue();
//                String valueRemainingDebt = xmlData[4].getChildByName("value").getValue();
//
//                String codeRemainingDebtPercent = xmlData[5].getChildByName("code").getValue();
//                String valueRemainingDebtPercent = xmlData[5].getChildByName("value").getValue();
//
//
//                String checksecondActionRequest = "<root>\n" +
//                        "    <action>next</action>\n" +
//                        "    <fields>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeFullName + "</code>\n" +
//                        "         <value>" + valueFullName + "</value>\n" +
//                        "        </item>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeSubscriptionCode + "</code>\n" +
//                        "         <value>" + valueSubscriptionCode + "</value>\n" +
//                        "        </item>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeCounterNumber + "</code>\n" +
//                        "         <value>" + valueCounterNumber + "</value>\n" +
//                        "        </item>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeSubscribeType + "</code>\n" +
//                        "         <value>" + valueSubscribeType + "</value>\n" +
//                        "        </item>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeRemainingDebt + "</code>\n" +
//                        "         <value>" + valueRemainingDebt + "</value>\n" +
//                        "        </item>\n" +
//                        "        <item>\n" +
//                        "         <code>" + codeRemainingDebtPercent + "</code>\n" +
//                        "         <value>" + valueRemainingDebtPercent + "</value>\n" +
//                        "        </item>\n" +
//                        "    </fields>\n" +
//                        "     <session>" + session + "</session>\n" +
//                        "    <totalFeeSum>0</totalFeeSum>\n" +
//                        "    <totalPurchaseSum>0</totalPurchaseSum>\n" +
//                        "</root>\n";
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " secondAction().checkSecondActionRequest  body : " + checksecondActionRequest);
//                }
//
//                headers.setContentType(MediaType.TEXT_XML);
//                HttpEntity<String> httpEntity = new HttpEntity<>(checksecondActionRequest, headers);
//
//                String uri = pluginConfig.getUrl() + "/action";
//
//                ResponseEntity<String> response1 = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
//                actionResponse = response1.getBody();
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " secondAction().checkSecondActionResponse : " + actionResponse);
//                }
//                return actionResponse;
//
//            }
//        } catch (ParserConfigurationException | IOException | SAXException | MPayException e) {
//            e.printStackTrace();
//            LOGGER.error(BillingMPay.logPrefix + "Error occurred while checking secondAction request ", e);
//        }
//        return actionResponse;
//    }
//
//    String payItemAction(String response, RestTemplate restTemplate, HttpHeaders headers) {
//        String actionResponse = null;
//
//        try {
//            XML_Data xd = XMLHashedParser.parseXmlString(response);
//
//            if (xd.getChildByName("root").getChildByName("code").getValue().equals("SUCCESS_EXIST_NEXT")) {
//                String session = xd.getChildByName("root").getChildByName("session").getValue();
//
//                XML_Data[] xmlData = xd.getChildByName("root").getChildByName("session").getChildByName("fields").getChilds();
//                String code = xmlData[0].getChildByName("code").getValue();
//
//                XML_Data[] payType = xmlData[0].getChildByName("values").getChilds();
//                String payment = payType[0].getChildByName("value").getValue();
//                String recovery = payType[1].getChildByName("value").getValue();
//                String checkPayItemActionRequest;
//
//                if (pluginConfig.getPayType().equals(payment)) {
//                    checkPayItemActionRequest = " <root>\n" +
//                            "     <action>next</action>\n" +
//                            "     <fields>\n" +
//                            "        <item>\n" +
//                            "         <code>" + code + "</code>\n" +
//                            "         <value>" + payment + "</value>\n" +
//                            "        </item>\n" +
//                            "     </fields>\n" +
//                            "     <session>" + session + "</session>\n" +
//                            "     <totalFeeSum>0</totalFeeSum>\n" +
//                            "     <totalPurchaseSum>0</totalPurchaseSum>\n" +
//                            " </root>";
//                } else {
//                    checkPayItemActionRequest = " <root>\n" +
//                            "     <action>next</action>\n" +
//                            "     <fields>\n" +
//                            "        <item>\n" +
//                            "         <code>" + code + "</code>\n" +
//                            "         <value>" + recovery + "</value>\n" +
//                            "        </item>\n" +
//                            "     </fields>\n" +
//                            "     <session>" + session + "</session>\n" +
//                            "     <totalFeeSum>0</totalFeeSum>\n" +
//                            "     <totalPurchaseSum>0</totalPurchaseSum>\n" +
//                            " </root>";
//                }
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " payItemAction().checkpayItemActionnRequest  body : " + checkPayItemActionRequest);
//                }
//
//                headers.setContentType(MediaType.TEXT_XML);
//                HttpEntity<String> httpEntity = new HttpEntity<>(checkPayItemActionRequest, headers);
//
//                String uri = pluginConfig.getUrl() + "/action";
//
//                ResponseEntity<String> responseForPayment = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
//                actionResponse = responseForPayment.getBody();
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " payItemAction().checkactionResponse : " + actionResponse);
//                }
//
//            }
//        } catch (ParserConfigurationException | IOException | SAXException | MPayException e) {
//            e.printStackTrace();
//            LOGGER.error(BillingMPay.logPrefix + "Error occurred while checking payItemAction request ", e);
//        }
//        return actionResponse;
//    }
//
//    private String recoveryPaymentCheck(String response, RestTemplate restTemplate, HttpHeaders headers) {
//        String actionResponse = null;
//
//        try {
//            XML_Data xd = XMLHashedParser.parseXmlString(response);
//
//            if (xd.getChildByName("root").getChildByName("code").getValue().equals("SUCCESS_EXIST_NEXT")) {
//                String session = xd.getChildByName("root").getChildByName("session").getValue();
//
//                XML_Data[] xmlData = xd.getChildByName("root").getChildByName("session").getChildByName("fields").getChilds();
//                String recoveryPayment = xmlData[0].getChildByName("code").getValue();
//
//                XML_Data[] payType = xmlData[0].getChildByName("tableItems").getChilds();
//                String payment = payType[0].getChildByName("elements").getValue();
//                String recovery = payType[1].getChildByName("value").getValue();
//
//                String checkPayItemActionRequest = "  <root>\n" +
//                        "     <action>next</action>\n" +
//                        "     <fields>\n" +
//                        "        <item>\n" +
//                        "         <code>recovery_payment</code>\n" +
//                        "         <value>2</value>\n" +
//                        "        </item>\n" +
//                        "     </fields>\n" +
//                        "     <session>c11e91a6-358d-4af0-8fbc-5cebab89dfad</session>\n" +
//                        "     <totalFeeSum>0</totalFeeSum>\n" +
//                        "     <totalPurchaseSum>0</totalPurchaseSum>\n" +
//                        " </root>\n";
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " payItemAction().checkpayItemActionnRequest  body : " + checkPayItemActionRequest);
//                }
//
//                headers.setContentType(MediaType.TEXT_XML);
//                HttpEntity<String> httpEntity = new HttpEntity<>(checkPayItemActionRequest, headers);
//
//                String uri = pluginConfig.getUrl() + "/action";
//
//                ResponseEntity<String> response1 = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
//                actionResponse = response1.getBody();
//
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug(BillingMPay.logPrefix + " payItemAction().checkpayItemActionResponse : " + actionResponse);
//                }
//                return actionResponse;
//
//            }
//        } catch (ParserConfigurationException | IOException | SAXException | MPayException e) {
//            e.printStackTrace();
//            LOGGER.error(BillingMPay.logPrefix + "Error occurred while checking payItemAction request ", e);
//        }
//        return actionResponse;
//    }
//
//}
