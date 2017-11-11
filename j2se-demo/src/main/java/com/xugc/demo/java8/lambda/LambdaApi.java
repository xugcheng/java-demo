package com.xugc.demo.java8.lambda;

import com.xugc.demo.domain.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by xuguocheng on 2017/4/20.
 */
public class LambdaApi {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person(1, "A"),
                new Person(3, "B"),
                new Person(2, "C")
        );

        //lambda语法

        Collections.sort(persons, (o1, o2) -> o1.getId().compareTo(o2.getId()));

        Collections.sort(persons, ((o1, o2) -> o1.getId() - o2.getId()));

        Collections.sort(persons, Comparator.comparing(person -> person.getId()));

        System.out.println(persons);
        System.out.println("**********************");

        //Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(persons, Comparator.comparing(person -> person.getName()));

        System.out.println(persons);

        System.out.println("**********************");

        Collections.sort(persons, (Person o1, Person o2) -> {

            System.out.println(o1 + ":" + o2);

            return o1.getId().compareTo(o2.getId());
        });

        System.out.println("**********************");

        System.out.println(persons);


        //外部变量

        String[] array = {"a", "b", "c"};
        for (int i : Arrays.asList(1, 2, 3)) {
            Stream.of(array).map(item -> (item + "@" + i * i)).forEach(System.out::println);
        }

        System.out.println("**********************");

        for (int i = 1; i < 4; i++) {
            final int index = i;
            Stream.of(array).map(item -> (item + "@" + index)).forEach(System.out::println);
        }


        //lambda眼中的this,不是指向lambda表达式产生的SAM对象,而是声明他的外部对象.

        Stream.of(array).map(String::toUpperCase).forEach(System.out::println);

        StringBuilder sb = new StringBuilder();

        Stream.of(array).map(Person::new).forEach(System.out::println);

        Stream.of(array).map(item -> item + "-").forEach(sb::append);

        System.out.println(sb);
    }
}
