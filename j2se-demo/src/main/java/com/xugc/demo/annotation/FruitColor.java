package com.xugc.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by xuguocheng on 2017/7/7.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color {
        BLUE, RED, GREEN
    }

    /**
     * fruit color
     *
     * @return
     */
    public Color fruitColor() default Color.GREEN;
}
