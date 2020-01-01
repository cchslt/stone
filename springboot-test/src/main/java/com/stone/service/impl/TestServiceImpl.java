package com.stone.service.impl;

import com.stone.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chen
 * @create 2020-01-01 11:36
 **/

@Service
public class TestServiceImpl implements TestService {


    @Async
    @Override
    public void ascrMethod() {
        System.out.println("异步方法调用开始。。。。");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步方法调用结束, 耗时: " + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void sycMethod() {
        System.out.println("同步方法调用开始。。。。");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法调用结束, 耗时: " + (System.currentTimeMillis() - startTime));

    }
}
