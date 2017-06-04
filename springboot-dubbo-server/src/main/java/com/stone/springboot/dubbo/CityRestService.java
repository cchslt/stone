package com.stone.springboot.dubbo;


import com.stone.springboot.domain.City;

/**
 * 城市业务 Dubbo 服务层
 *
 * Created by chenchen on 17/6/4.
 */
public interface CityRestService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCity(String cityName);
}
