package com.stone.service.impl;

import com.stone.dao.springboottest.CityRestDao;
import com.stone.domain.City;
import com.stone.service.CityRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenchen on 2017/6/3.
 */
@Service
public class CityRestServiceImpl implements CityRestService {
    @Autowired
    private CityRestDao cityRestDao;

    @Override
    public City findCity(String cityName) {
        System.out.println(cityName);
        return cityRestDao.findCity(cityName);
    }
}
