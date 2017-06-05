package com.stone;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by chenchen on 2017/6/5.
 */
public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);

        //多线程，put操作引起死循环，CPU使用率接近100%
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i =0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "11");
                        }
                    }, "stone " + i).start();
                }
            }
        }, "stone");

        thread.start();
        thread.join();
    }
}
