package com.atguigu.redis.test;

import redis.clients.jedis.Jedis;

// 主从复制
public class TextMS {
    public static void main(String[] args) {
        Jedis jedis_M = new Jedis("127.0.0.1" , 6379) ;
        Jedis jedis_S = new Jedis("127.0.0.1" , 6380) ;

        jedis_S.slaveof("127.0.0.1" , 6379) ;   // 从机

        jedis_M.set("class" , "112") ;   // 主机写
        String s = jedis_S.get("class");

        System.out.println(s) ;
    }

}
