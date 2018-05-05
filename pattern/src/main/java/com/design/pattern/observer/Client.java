package com.design.pattern.observer;

public class Client {

    public static void main(String[] args) {
        NewsPaper newsPaper = new NewsPaper();

        Reader reader1 = new Reader();
        Reader reader2 = new Reader();
        Reader reader3 = new Reader();

        reader1.setName("张三");
        reader2.setName("李四");
        reader3.setName("王五");

        newsPaper.attach(reader1);
        newsPaper.attach(reader2);
        newsPaper.attach(reader3);

        newsPaper.setContext("本期的内容是雷军要上市了");
    }

}
