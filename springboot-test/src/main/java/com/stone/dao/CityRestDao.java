package com.stone.dao;

import com.stone.domain.City;

/**
 * Created by chenchen on 2017/6/3.
 */
public interface CityRestDao {
    City findCity(String cityName);
}
