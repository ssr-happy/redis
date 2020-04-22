package com.atguigu.redis.test;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

// 使用单例模式(调试Jedis池)
public class JedisPoolUtil {

    // volatile关键字的作用：保证了变量的可见性（visibility）。
    // 被volatile关键字修饰的变量，如果值发生了变更，其他线程立马可见，避免出现脏读的现象。
    private static volatile JedisPool jedisPool = null ;

    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance() {

        // 判断改变量是否为空
        if(null == jedisPool) {
            // 如果为空，则进行同步处理
            synchronized (JedisPoolUtil.class) {
                // 再次判断
                if(null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig() ;
                    // poolConfig.setMaxActive(1000);
                    poolConfig.setMaxIdle(32);
                    // poolConfig.setMaxWait(100*1000);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig ,"127.0.0.1" , 6379) ;
                }
            }
        }

        return null ;
    }


}
