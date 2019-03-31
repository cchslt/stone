package com.design.pattern.singleton;

public class SingletonThrid {
    private SingletonThrid() {}  //私有构造函数
    //针对第二种，可能会出现指令重排的情况，增加volatile关键字是为了防止指令重排
    private volatile static SingletonThrid instance = null;  //单例对象

    public static SingletonThrid getInstance() {
        if (null == instance) { //双重检测机制
            synchronized (SingletonThrid.class) { //同步锁
                if (null == instance) { //双重检测机制
                    instance = new SingletonThrid();
                }
            }
        }

        return instance;
    }
}
