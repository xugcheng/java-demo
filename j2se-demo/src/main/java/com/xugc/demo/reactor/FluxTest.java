package com.xugc.demo.reactor;

import reactor.core.publisher.Flux;

public class FluxTest {

    public static void main(String[] args) {

        Flux.just("x", "y", "z").subscribe(System.out::println);
        Flux.fromArray(new String[]{"a", "b", "c"}).subscribe(System.out::println);
        Flux.range(1, 3).subscribe(System.out::println);
        System.out.println(Flux.range(1, 3).blockFirst());
        System.out.println(Flux.range(1, 3).blockLast());
    }
}
