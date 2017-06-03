package com.stone.service.impl;

import com.stone.dao.springboottest.CityRestDao;
import com.stone.dao.test.UserInfoDao;
import com.stone.domain.City;
import com.stone.domain.UserInfo;
import com.stone.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenchen on 2017/6/4.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private CityRestDao cityRestDao;

    @Override
    public UserInfo findUser(int userId) {
        UserInfo userInfo = userInfoDao.findUser(userId);
        City city = cityRestDao.findCity("guangxi");
        userInfo = null == userInfo ? new UserInfo() : userInfo;
        userInfo.setCity(city);
        return userInfo;
    }
}
