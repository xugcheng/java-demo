package com.xugc.demo.rxjava;

import rx.Observable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TickTime {

    public static void main(String[] args) throws Exception {

        Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

        Observable<Long> clock = Observable.merge(
                slow.filter(tick -> isSlowTime()),
                fast.filter(tick -> !isSlowTime())
        );

        clock.subscribe(tick -> System.out.println(tick + "," + new Date()));

        TimeUnit.SECONDS.sleep(60);
    }

    private static long start = System.currentTimeMillis();

    public static Boolean isSlowTime() {
        return (System.currentTimeMillis() - start) % 30000 >= 15000;
    }
}
