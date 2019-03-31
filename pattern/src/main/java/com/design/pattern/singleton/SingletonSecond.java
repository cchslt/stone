package com.design.pattern.singleton;

public class SingletonSecond {
    private SingletonSecond() {}  //私有构造函数
    private static SingletonSecond instance = null;  //单例对象

    public static SingletonSecond getInstance() {
        if (null == instance) { //双重检测机制
            synchronized (SingletonSecond.class) { //同步锁
                if (null == instance) { //双重检测机制
                    instance = new SingletonSecond();
                }
            }
        }

        return instance;
    }
}
