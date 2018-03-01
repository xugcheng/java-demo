package com.xugc.demo.collections.map;

public class HashCodeTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int hashCode = Integer.valueOf(i).hashCode();
            int hashCode2 = hashCode ^ (hashCode >>> 16);
            System.out.println(hashCode + " : " + hashCode2);
        }
        for (int i = 0; i < 10; i++) {
            int hashCode = String.valueOf(i).hashCode();
            int hashCode2 = hashCode ^ (hashCode >>> 16);
            System.out.println(hashCode + " : " + hashCode2);
        }
        for (int i = 0; i < 10; i++) {
            int hashCode = new Object().hashCode();
            int hashCode2 = hashCode ^ (hashCode >>> 16);
            System.out.println(hashCode + " : " + hashCode2);
        }

        hashCode(new Object());
    }

    public static int hashCode(Object key) {

        int h;

        h = key.hashCode();

        System.out.println(String.format("%10d : %32s", h, Integer.toBinaryString(h)));

        int h1 = h >>> 16;

        System.out.println(String.format("%10d : %32s", h1, Integer.toBinaryString(h1)));

        int h2 = h ^ h1;

        System.out.println(String.format("%10d : %32s", h2, Integer.toBinaryString(h2)));

        return h2;
        // return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
