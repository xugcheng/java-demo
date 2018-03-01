package com.xugc.demo.collections.map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(3, 3);
        map.put(2, 2);
        map.put(4, 4);
        map.put(1, 1);

        System.out.println("map : " + map);

        System.out.println("map.lowerEntry(3) : " + map.lowerEntry(3));
        System.out.println("map.floorEntry(3) : " + map.floorEntry(3));
        System.out.println("map.higherEntry(2) : " + map.higherEntry(2));
        System.out.println("map.ceilingEntry(2) : " + map.ceilingEntry(2));
        System.out.println("map.firstEntry() : " + map.firstEntry());
        System.out.println("map.lastEntry() : " + map.lastEntry());


        NavigableMap<Integer, Integer> descendingMap = map.descendingMap();
        descendingMap.put(6, 6);
        System.out.println("descendingMap : " + descendingMap);
        System.out.println("map : " + map);

        System.out.println("descendingMap.lowerEntry(3) : " + descendingMap.lowerEntry(3));
        System.out.println("descendingMap.floorEntry(3) : " + descendingMap.floorEntry(3));
        System.out.println("descendingMap.higherEntry(2) : " + descendingMap.higherEntry(2));
        System.out.println("descendingMap.ceilingEntry(2) : " + descendingMap.ceilingEntry(2));
        System.out.println("descendingMap.firstEntry() : " + descendingMap.firstEntry());
        System.out.println("descendingMap.lastEntry() : " + descendingMap.lastEntry());

    }
}
