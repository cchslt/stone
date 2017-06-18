package com.stone;

import com.stone.util.SleepUtils;

/**
 * Created by chenchen on 2017/6/18.
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaiting").start();
        new Thread(new Waiting(), "Waiting").start();
        new Thread(new Blocked(), "Blocked--1").start();
        new Thread(new Blocked(), "Blocked--2").start();
    }

    static class TimeWaiting implements Runnable{

        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable{
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        public void run() {
            synchronized (Blocked.class) {
                SleepUtils.second(100);
            }
        }
    }
}
