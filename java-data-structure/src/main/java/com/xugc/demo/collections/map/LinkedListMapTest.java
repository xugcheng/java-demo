package com.xugc.demo.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedListMapTest {

    public static void main(String[] args) {


        System.out.println("***********LinkedHashMap***********");

        Map<Integer, Integer> map = new LinkedHashMap<>(16, 0.75F, true);
        map.put(1, 1);
        map.put(3, 3);
        map.put(4, 4);
        map.put(2, 2);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        map.put(4, 4);
        map.put(1, 1);
//        map.put(3, 3);
//        map.put(2, 2);

        System.out.println("map.put(4, 4);");
        System.out.println("map.put(1, 1);");

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("***********HashMap***********");

        map = new HashMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(4, 4);
        map.put(2, 2);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("***********TreeMap***********");

        map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(4, 4);
        map.put(2, 2);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
