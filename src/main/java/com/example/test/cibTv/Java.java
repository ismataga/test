package com.example.test.cibTv;

public class Java {



    public static void main(String[] args) {
        Bank bank = new Bank("az");
        Bank bank1 = new Bank("az");
        Integer a = 5;
        Integer b =5;

        Integer m = 150;
        Integer n =150;


        System.out.println(m==n);
        System.out.println(m.equals(n));
        System.out.println("--------------------------------");

        String aa = "aa";
        String bb = "aa";
        String cc =new String("aa");
        cc.intern();
        System.out.println(aa==bb);
        System.out.println(aa.equals(bb));
        System.out.println(aa==cc);
        System.out.println("--------------------------------");
        System.out.println(bank==bank1);
        System.out.println(bank.equals(bank1));


    }
}
