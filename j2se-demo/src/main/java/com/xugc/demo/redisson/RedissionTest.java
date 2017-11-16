package com.xugc.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.Iterator;
import java.util.Random;

public class RedissionTest {

    public static void main(String[] agrs) throws Exception {

        Random random = new Random();

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");


        RedissonClient client = Redisson.create(config);

        //同部操作接口
        RMap<String, String> map = client.getMap("map");
        String old = map.put("foo", "bar" + random.nextInt());
        System.out.println("old:" + old);
        System.out.println("now:" + map.get("foo"));

        //异步操作接口
        RMapAsync<String, String> mapAsync = client.getMap("map");
        RFuture<String> future = mapAsync.putAsync("x", "y" + random.nextInt());
        System.out.println("old:" + future.get());
        System.out.println("now:" + future.isSuccess());

        //keys
        RKeys keys = client.getKeys();
        Iterable<String> allKeys = keys.getKeys();
        Iterator<String> iterator = allKeys.iterator();
        while (iterator.hasNext()) {
            System.out.println("key:" + iterator.next());
        }

        System.out.println("keys.randomKey()=" + keys.randomKey());
        System.out.println("keys.randomKey()=" + keys.randomKey());
        System.out.println("keys.randomKey()=" + keys.randomKey());
        System.out.println("keys.randomKey()=" + keys.randomKey());
        System.out.println("keys.randomKey()=" + keys.randomKey());

        //bucket
        RBucket<String> bucket = client.getBucket("bucket");
        bucket.set("abc");
        bucket.trySet("xyz");
        bucket.compareAndSet("xyz", "123");
        bucket.getAndSet("456");

        //二进制流
        RBinaryStream binaryStream = client.getBinaryStream("binary_stream");
        binaryStream.set("你好".getBytes());
        System.out.println(new String(binaryStream.get()));

        //geo
        RGeo<String> geo = client.getGeo("geo");
        geo.add(113.95402818918228149, 22.55048517933375507, "pos3");
        geo.add(113.95032674074172974, 22.54391011264642231, "pos4");
        RFuture<Double> distance = geo.distAsync("pos3", "pos4", GeoUnit.METERS);
        distance.await();
        System.out.println("distance:" + distance.get());
        System.out.println(geo.hash("pos1", "pos2", "pos3", "pos4"));

        //atomicLong
        RAtomicLong atomicLong = client.getAtomicLong("atomicLong");
        System.out.println("atomicLong:" + atomicLong.incrementAndGet());
        System.out.println("atomicLong:" + atomicLong.incrementAndGet());
        System.out.println("atomicLong:" + atomicLong.incrementAndGet());
        System.out.println("atomicLong:" + atomicLong.incrementAndGet());

        //bloomFilter
        RBloomFilter<String> bloomFilter = client.getBloomFilter("sample");
        bloomFilter.tryInit(55000000L, 0.03);
        bloomFilter.add("a");
        bloomFilter.add("b");
        bloomFilter.add("c");
        System.out.println(bloomFilter.contains("x"));
        System.out.println(bloomFilter.contains("y"));
        System.out.println(bloomFilter.contains("a"));
    }
}
