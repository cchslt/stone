package com.stone.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenchen on 2017/6/18.
 */
public class SleepUtils {
    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
