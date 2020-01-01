package com.stone.web;

import com.stone.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenchen on 2017/5/31.
 * @RestController: 提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
 * @RequestMapping: 提供路由信息，”/“路径的HTTP Request都会被映射到sayHello方法进行处理
 */
@RestController
public class HelloWorldController {

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    public String showPage() {
        return "Hello World!";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        System.out.println("异步");
        long startTime = System.currentTimeMillis();
        testService.ascrMethod();
        System.out.println("异步。。 " + (System.currentTimeMillis() - startTime));
        return "hello1";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        long startTime = System.currentTimeMillis();
        testService.sycMethod();
        System.out.println("同步。。 " + (System.currentTimeMillis() - startTime));
        return "hello2";
    }

}
