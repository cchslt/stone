package com.stone.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stone.springboot.domain.City;
import com.stone.springboot.dubbo.CityRestService;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by chenchen on 17/6/4.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityRestServiceImpl implements CityRestService {

    public City findCity(String cityName) {
        return new City(1000L,11L,"guagnxi","liusanjie");
    }
}
