package com.stone;

import com.stone.util.SleepUtils;

/**
 * Created by chenchen on 2017/6/18.
 */
public class Daemon {
    public static void main(String[] args) {
        /**
         * main线程启动了DaemonRunner线程，之后随着main方法执行完毕而终止
         * 此时java虚拟机中已经没有非daemon线程，虚拟机退出
         * 虚拟机中所有的daemon线程都需要立即终止，因此 DaemonRunner 立即结束，DaemonRunner中finally块没有执行
         */
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("end finally run.");
            }
        }
    }
}
