package com.xugc.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by xuguocheng on 2017/7/7.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    public int id() default -1;

    public String name() default "";

    public String address() default "";
}
