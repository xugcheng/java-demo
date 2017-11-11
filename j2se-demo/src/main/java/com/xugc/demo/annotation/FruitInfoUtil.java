package com.xugc.demo.annotation;

import java.lang.reflect.Field;

/**
 * Created by xuguocheng on 2017/7/7.
 */
public class FruitInfoUtil {

    public static void getFruntInfo(Class<?> classz) {

        Field[] fields = classz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("水果名称:" + fruitName.value());
            }
            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("水果颜色:" + fruitColor.fruitColor());
            }
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println("水果供应商:" + fruitProvider.id() + "-" + fruitProvider.name() + "-" + fruitProvider.address());
            }
        }

    }

    public static void main(String[] args) {

        Apple apple = new Apple();
        FruitInfoUtil.getFruntInfo(apple.getClass());
    }
}
