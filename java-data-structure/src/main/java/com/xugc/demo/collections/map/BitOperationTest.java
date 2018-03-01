package com.xugc.demo.collections.map;

public class BitOperationTest {

    public static void main(String[] args) {

        int x1 = 5;
        int x2 = -5;

        //左移
        int x1_left = x1 << 2;
        //右移
        int x1_right = x1 >> 2;
        //无符号右移
        int x1_uright = x1 >>> 2;

        int x2_left = x2 << 2;
        int x2_right = x2 >> 2;
        int x2_uright = x2 >>> 2;

        int[] as = new int[]{
                x1, x1_left, x1_right, x1_uright,
                x2, x2_left, x2_right, x2_uright
        };

        for (int x : as) {
            System.out.println(String.format("%10d : %32s", x, Integer.toBinaryString(x)));
        }
    }
}
