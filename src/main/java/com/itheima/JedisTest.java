package com.itheima;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.92.92",6379);

//        String pong = jedis.ping();
//        System.out.println(pong);

        System.out.println("请输入手机号:");
        Scanner sc = new Scanner(System.in);
        String phone = sc.next();
        //先判断是否是第一次登录
        if(jedis.get(phone) == null){
            jedis.set(phone,"1");
        }else {
            if(Integer.parseInt(jedis.get(phone) )== 3){
                System.out.println("三次机会已经用完");
                return;
            }
            jedis.incr(phone);
        }
        System.out.println("请输入验证码:");
        String code = sc.next();
    }
}
