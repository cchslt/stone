package com.stone.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stone.springboot.domain.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by chenchen on 17/6/4.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityRestService cityRestService;

    public void printCity() {
        String cityName="1";
        City city = cityRestService.findCity(cityName);
        System.out.println(city.toString());
    }
}
