package com.stone.web;

import com.stone.domain.UserInfo;
import com.stone.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenchen on 2017/6/3.
 */
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public UserInfo findCity(@RequestParam(value = "userId", required = false) int userId){
        return userInfoService.findUser(userId);
    }
}
