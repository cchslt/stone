package com.stone.service;

import com.stone.domain.UserInfo;

/**
 * Created by chenchen on 2017/6/4.
 */
public interface UserInfoService {
    UserInfo findUser(int userId);
}
