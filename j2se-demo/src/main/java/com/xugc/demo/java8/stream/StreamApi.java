package com.xugc.demo.java8.stream;

import com.xugc.demo.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8的stream api测试
 * Created by xuguocheng on 2017/4/20.
 */
public class StreamApi {

    public static void main(String[] args) {

        //创建stream
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        Arrays.asList(1, 2, 3, 4).stream().forEach(System.out::println);

        //转换stream
        Person[] persons = new Person[]{
                new Person(1, "A"),
                new Person(3, "B"),
                new Person(2, "C"),
        };

        List<Integer> ids = Stream.of(persons)
                .map(Person::getId)
                .sorted()
                .collect(Collectors.toList());
        List<String> names = Stream.of(persons)
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ids);
        System.out.println(names);

        Integer[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 1};
        Stream.of(array).distinct().sorted().forEach(System.out::println);
        Integer max = Stream.of(array).max((o1, o2) -> o1.compareTo(o2)).get();
        Integer min = Stream.of(array).min((o1, o2) -> o1.compareTo(o2)).get();
        long count = Stream.of(array).count();
        System.out.println("max:" + max + ",min:" + min + ",count:" + count);

        Stream.of(array).filter(x -> x < 5).forEach(System.out::println);

        Function<Integer,String> f = (integer -> String.valueOf(integer)+"@");
        System.out.println(f.apply(1));


        //组合函数
        Function<Integer,Integer> times2 = e -> e*2;
        Function<Integer,Integer> square = e -> e*e;

        System.out.println(times2.compose(square).apply(3));
        System.out.println(times2.andThen(square).apply(3));

    }
}

