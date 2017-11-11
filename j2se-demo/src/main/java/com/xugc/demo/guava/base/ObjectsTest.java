package com.xugc.demo.guava.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.xugc.demo.domain.Person;

/**
 * Created by xuguocheng on 2017/9/18.
 */
public class ObjectsTest {

    public static void main(String[] args) {

        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal(null, null));

        //
        String str = MoreObjects.toStringHelper(Person.class)
                .add("name", "张三")
                .add("age", 20)
                .toString();

        System.out.println(str);

        System.out.println(MoreObjects.firstNonNull("x", null));
        System.out.println(MoreObjects.firstNonNull(null, "x"));
    }
}
