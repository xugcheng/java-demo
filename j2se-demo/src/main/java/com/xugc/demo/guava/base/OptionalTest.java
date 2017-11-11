package com.xugc.demo.guava.base;

import com.google.common.base.Optional;

/**
 * Created by xuguocheng on 2017/9/18.
 */
public class OptionalTest {

    public static void main(String[] args) {

        String x = "1";
        String y = null;

        Optional<String> ox = Optional.of(x);
        System.out.println(ox + "=" + ox.or("x"));

        Optional<String> oy = Optional.fromNullable(y);
        System.out.println(oy + "=" + oy.or("y"));

        Optional absent = Optional.absent();
        System.out.println(absent + "=" + absent.or(0));
    }
}
