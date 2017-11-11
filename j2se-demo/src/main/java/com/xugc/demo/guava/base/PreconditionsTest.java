package com.xugc.demo.guava.base;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by xuguocheng on 2017/9/18.
 */
public class PreconditionsTest {

    public static void main(String[] args) {

        System.out.println(divide(3, 4));

        System.out.println(divide(3, 0));

    }

    public static double divide(int x, int y) {

        checkArgument(y != 0, "除数不能等于0");

        return (double) x / (double) y;
    }

}
