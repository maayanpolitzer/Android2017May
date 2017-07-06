package com.company;

public class Main {

    public static void main(String[] args) {

        // convert upward.
        int number = 40;
        long x = number;

        // convert downward.
        // 1. casting.
        short s = 130;
        byte b = (byte)s;
        System.out.println(b);

        //2. helper classes:
        long l = 9384734875L;
        l += 1000000000;
        System.out.println(l);
        //short s2 = (short) l;
        Long longObject = new Long(l);
        short s2 = longObject.shortValue();
        System.out.println(s2);

        float f = 6.3f;

        System.out.println(f);
    }
}
