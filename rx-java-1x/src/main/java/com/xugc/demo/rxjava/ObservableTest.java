package com.xugc.demo.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableTest {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dog"
        );

        //多个参数输出
        Observable.just("hello", "world").subscribe(System.out::println);

        System.out.println(" ");

        //数组一行输出
        Observable.just(words).subscribe(word -> System.out.println(word));

        System.out.println(" ");

        //数组多行输出
        Observable.from(words).subscribe(System.out::println);

        System.out.println(" ");

        //合并多个流
        Observable.from(words)
                .zipWith(Observable.range(1, Integer.MAX_VALUE)
                        , (word, count) -> String.format("%d.%s", count, word))
                .subscribe(System.out::println);

        System.out.println(" ");

        //流变形
        Observable.from(words)
                .flatMap(word -> Observable.from(word.split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE)
                        , (word, count) -> String.format("%d.%s", count, word))
                .subscribe(System.out::println);

        System.out.println(" ");
        //merge,保持顺序
        Observable.just(1, 3)
                .mergeWith(Observable.just(2, 4))
                .subscribe(System.out::println);

        System.out.println(" ");

        //debounce,
        Observable.range(1, 10000)
                .debounce(1, TimeUnit.MICROSECONDS)
                .subscribe(System.out::println);
        
    }
}
