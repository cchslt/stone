package com.design.pattern.singleton;

public class SingletonFirst {

    private SingletonFirst() {}
    private static SingletonFirst instance = null; //单例对象

    //静态工厂方法
    public static SingletonFirst getInstance() {
        if (null == instance) {
            instance = new SingletonFirst();
        }
        return instance;
    }

}
