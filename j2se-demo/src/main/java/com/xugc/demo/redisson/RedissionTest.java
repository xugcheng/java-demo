package com.xugc.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionTest {

    public static void main(String[] agrs) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        RMap<String, String> map = client.getMap("map");
        map.put("foo", "bar");

        System.out.println(map.get("foo"));

    }
}
