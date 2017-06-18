package com.stone;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by chenchen on 2017/6/18.
 */
public class MultiThread {

    public static void main(String[] args) {
        //��ȡ�̹߳���MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //����Ҫ��ȡͬ����monitor��synchronizer��Ϣ��ֻ��ȡ�̺߳��̶߳�ջ��Ϣ
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            /**
             * [ 4 ] Signal Dispatcher  �ַ������͸�JVM�źŵ��߳�
             * [ 3 ] Finalizer          ���ö���finalizer�������߳�
             * [ 2 ] Reference Handler  ����Reference���߳�
             * [ 1 ] main               main�����û��������
             */
            System.out.println("[ " + threadInfo.getThreadId() + " ] " + threadInfo.getThreadName());
        }
    }
}
