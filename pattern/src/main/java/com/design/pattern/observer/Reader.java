package com.design.pattern.observer;


/**
 *
 * 观察者具体对象，用来接受通知，处理逻辑
 */
public class Reader implements Observer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void uodate(Subject subject) {
        System.out.println(name +" 收到了报纸\n 报纸的内容为： " + ((NewsPaper)subject).getContext());
    }
}
