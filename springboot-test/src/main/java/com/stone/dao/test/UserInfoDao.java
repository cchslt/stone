package com.stone.dao.test;

import com.stone.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chenchen on 2017/6/4.
 */
public interface UserInfoDao {
    UserInfo findUser(@Param("userId") int userId);
}
