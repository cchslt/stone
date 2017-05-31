package com.stone.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenchen on 2017/5/31.
 * @RestController: 提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
 * @RequestMapping: 提供路由信息，”/“路径的HTTP Request都会被映射到sayHello方法进行处理
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String showPage() {
        return "Hello World!";
    }
}
