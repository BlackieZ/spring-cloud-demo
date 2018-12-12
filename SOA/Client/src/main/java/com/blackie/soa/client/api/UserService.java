package com.blackie.soa.client.api;


import com.blackie.soa.client.model.UserLoginParam;
import com.blackie.soa.client.model.UserLoginResult;

/**
 * Created by BlackieZ 365227949@qq.com
 */
public interface UserService {
    /**
     * 用户登录接口
     * @param param
     * @return
     */
    UserLoginResult userLogin(UserLoginParam param);
}
