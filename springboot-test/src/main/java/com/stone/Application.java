package com.stone;

import com.stone.domain.Home;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by chenchen on 2017/5/31.
 */
@SpringBootApplication
@EnableAsync
// mapper 接口类扫描包配置
//@MapperScan("com.stone.dao.*")
public class Application implements CommandLineRunner{

    @Autowired
    private Home home;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(home.toString());
    }
}
