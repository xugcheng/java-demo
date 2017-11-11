package com.xugc.demo.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xuguocheng on 2017/7/19.
 */
public class MapTest {

    public static void main(String[] args) {

        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        Integer r1 = map.put("x", 1);
        System.out.println("put(x,1)=" + r1 + "," + map);
        Integer r2 = map.putIfAbsent("x", 2);
        System.out.println("putIfAbsent(x,2)=" + r2 + "," + map);
        boolean r3 = map.replace("x", 2, 3);
        System.out.println("replace(x,2,3)=" + r3 + "," + map);
    }
}
