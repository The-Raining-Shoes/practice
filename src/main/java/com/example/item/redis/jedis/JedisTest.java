package com.example.item.redis.jedis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

public class JedisTest {

    static String redisKey = "redisTest";

    public static void main(String[] args) {
        Jedis jedis1 = new Jedis("139.155.181.217", 6380);
        jedis1.set(redisKey, "20");
        // 清除redis所有数据
        Runnable runnable = () -> {
            Jedis jedis = new Jedis("139.155.181.217", 6380);
            while (true) {
                try {
                    jedis.watch(redisKey);
                    String redisValue = jedis.get(redisKey);
                    int valInteger = Integer.parseInt(redisValue);
                    if (valInteger <= 0) {
                        System.out.println("20张票已经全部抢完毕");
                        break;
                    } else {
                        // 开启事务
                        Transaction multi = jedis.multi();
                        // 库存减一操作
                        multi.decr(redisKey);
                        List<Object> exec = multi.exec();
                        String user = UUID.randomUUID().toString().substring(0, 16);
                        if (exec != null) {
                            System.out.println(user + "用户抢东西成功！库存减1");
                            break;
                        } else {
                            System.out.println(user + "用户抢东西失败");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    jedis.unwatch();
                    jedis.close();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(runnable, "线程" + i).start();
        }
    }

}
