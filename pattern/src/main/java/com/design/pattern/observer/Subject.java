package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Subject：具有以下功能
 * 1、一个目标对象可以对多个观察者观察
 * 2、提供观察者注册和退订的服务
 * 3、当目标状态发生改变时，负责通知所有注册、有效的观察者
 *
 */

public class Subject {

    private List<Observer> readers = new ArrayList<>();

    public void attach(Observer observer) {
        if (null != observer) {
            readers.add(observer);
        }
    }

    public void detach(Observer observer) {
        if (null != observer) {
            readers.remove(observer);
        }
    }

    public void notifyAllReaders() {
        if (readers.size() != 0) {
            //因为是从具体实例中调用，this表示当前调用的实例
            readers.forEach(reader -> reader.uodate(this));
        }
    }

}
