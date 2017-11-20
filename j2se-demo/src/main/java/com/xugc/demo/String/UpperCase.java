package com.xugc.demo.String;

public class UpperCase {

    public static void main(String[] args) {

        String str = " ab1徐 ";

        String str1 = str.trim();

        String str2 = str1.toUpperCase();

        System.out.println(str2);

        byte[] bytes = str2.getBytes();

        System.out.println(bytes.length);

        for (int i = 0; i < bytes.length; i++) {
            System.out.println(Integer.toBinaryString(0xFF & bytes[i]));
        }

    }
}
