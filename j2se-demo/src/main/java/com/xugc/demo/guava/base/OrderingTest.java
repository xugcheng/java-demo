package com.xugc.demo.guava.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;

/**
 * Created by xuguocheng on 2017/9/18.
 */
public class OrderingTest {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrderString = Ordering.arbitrary();

        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrderString:" + arbitraryOrderString.sortedCopy(list));
    }
}
