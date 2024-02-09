package com.example.test;

import java.util.Map;

public class LinkedHashMap {
    public static void main(String[] args) {


        Map<String, String> paramMap = new java.util.LinkedHashMap<>();
        paramMap.put("request_type", "1");
        paramMap.put("customer_id", "a");
        paramMap.put("amount", "20");
        paramMap.put("transaction_id", "15");
        paramMap.put("nonce", "nonce");
        String sign = sign(paramMap);
        System.out.println(sign);

    }

    private static String sign(Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            String value = param.getValue();

            if (value.length() > 0)
                s.append(String.valueOf(value.length())).append(value);
            else
                s.append('-');
        }
        return s.toString();
    }

}
