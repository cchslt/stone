package com.stone;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by chenchen on 2017/6/18.
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息，只获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            /**
             * [ 4 ] Signal Dispatcher  分发处理发送给JVM信号的线程
             * [ 3 ] Finalizer          调用对象finalizer方法的线程
             * [ 2 ] Reference Handler  调用Reference的线程
             * [ 1 ] main               main程序，用户程序入口
             */
            System.out.println("[ " + threadInfo.getThreadId() + " ] " + threadInfo.getThreadName());
        }
    }
}
