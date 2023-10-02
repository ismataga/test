package com.example.test.azeriqaz_smartcart;

import java.io.Serializable;

public class MyAttribute implements Serializable{
    private static final long serialVersionUID = 2544815931384206980L;
    private String name;
    private String value;

    public MyAttribute() {
    }

    public static MyAttribute createAttribute(String name, String value) {
        MyAttribute a = new MyAttribute();
        a.name = name;
        a.value = value;
        return a;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
