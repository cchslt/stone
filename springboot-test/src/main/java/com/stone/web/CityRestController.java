package com.stone.web;

import com.stone.domain.City;
import com.stone.service.CityRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenchen on 2017/6/3.
 */
@RestController
public class CityRestController {
    @Autowired
    private CityRestService cityRestService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findCity(@RequestParam(value = "cityName", required = false) String cityName){
        return cityRestService.findCity(cityName);
    }
}
