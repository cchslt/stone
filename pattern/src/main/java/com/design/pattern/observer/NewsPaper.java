package com.design.pattern.observer;


/**
 *
 * 具体的目标对象，维护目标的状态，当目标状态发生改变时，通知所有的注册和有效的观察者执行相应的处理
 *
 */
public class NewsPaper extends  Subject {

    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
        notifyAllReaders();
    }
}
