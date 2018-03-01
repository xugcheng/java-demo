package com.xugc.demo.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {

        test0();

        System.out.println("*****************");

        test1();

        System.out.println("*****************");

//        test2();

        System.out.println("*****************");

        test3();

        System.out.println("*****************");

        test4();
    }

    public static void test0() {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(null, 3);
        map.put(1, null);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(17, 17);
        map.put(33, 33);
        map.put(49, 49);
        map.put(65, 65);
        map.put(81, 81);
        map.put(97, 97);
        map.put(113, 113);
        map.put(129, 129);

        System.out.println(map);

        System.out.println("map.containsKey(null):" + map.containsKey(null));
        System.out.println("map.containsValue(null):" + map.containsValue(null));
        System.out.println(map.containsKey(new Object()));
        System.out.println(map.containsValue(new Object()));
        System.out.println(map.get(new Object()));
        System.out.println(map.getOrDefault(new Object(), 3));
        System.out.println(map.get(null));
        System.out.println(map.getOrDefault(null, 3));
    }

    public static void test1() {

        Map<Object, Object> map = new HashMap<>();
        map.put("x", 1);
        map.put("y", map);
        System.out.println(map);

        Set<Object> keys = map.keySet();
        for (Object key : keys) {
            Object val = map.get(key);
            System.out.println(key + "=" + val);
        }
    }

    public static void test2() {

        try {
            Map<Object, Object> map = new HashMap<>();
            map.put("x", 1);
            map.put(map, 2);
            System.out.println(map);

            Set<Object> keys = map.keySet();
            for (Object key : keys) {
                Object val = map.get(key);
                System.out.println(key + "=" + val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test3() {

        int len = 100 * 10000;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < 100; i++) {
            int randomint = new Random().nextInt(len);
            long start = System.currentTimeMillis();
            System.out.println(map.containsKey(randomint));
            System.out.println("containKey耗时:" + (System.currentTimeMillis() - start) + "ms");

            start = System.currentTimeMillis();
            System.out.println(map.containsValue(randomint));
            System.out.println("containValue耗时:" + (System.currentTimeMillis() - start) + "ms");
        }

    }

    public static void test4() {

        Map<Integer, Integer> map = new HashMap<>(1);
        map.put(1, 1);
    }
}
