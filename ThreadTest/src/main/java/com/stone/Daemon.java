package com.stone;

import com.stone.util.SleepUtils;

/**
 * Created by chenchen on 2017/6/18.
 */
public class Daemon {
    public static void main(String[] args) {
        /**
         * main�߳�������DaemonRunner�̣߳�֮������main����ִ����϶���ֹ
         * ��ʱjava��������Ѿ�û�з�daemon�̣߳�������˳�
         * ����������е�daemon�̶߳���Ҫ������ֹ����� DaemonRunner ����������DaemonRunner��finally��û��ִ��
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
