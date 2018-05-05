package com.design.pattern.observer;


/**
 *
 * 定义观察者接口
 * 1、提供目标更新时的方法，对业务逻辑进行处理
 * 2、科回调目标对象，以获取目标对象的数据
 *
 */

public interface Observer {

    public void uodate(Subject subject);
}
