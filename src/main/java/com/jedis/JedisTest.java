package com.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisTest {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
//        jedis.set("name","itheima");
//        String name = jedis.get("name");
        jedis.rpush("list1","a","b","c");
        List<String> list1 = jedis.lrange("list1", 0, -1);
//        System.out.println(list1);

    list1.forEach(System.out::println);
        jedis.close();
    }

}
