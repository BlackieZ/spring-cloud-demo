package com.blackie.soa.client.api;

import com.blackie.soa.client.model.*;
import feign.Headers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BlackieZ 365227949@qq.com
 */
public interface UserService {
    /**
     * 用户登录接口
     * @param param
     * @return
     */
    @Headers("Content-Type: application/json")
    @RequestMapping(value="/user/userLogin", method= RequestMethod.POST)
    UserLoginResult userLogin(UserLoginParam param);

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @Headers("Content-Type: application/json")
    @RequestMapping(value="/user/detail", method= RequestMethod.POST)
    GetUserDetailResult detail(GetUserDetailParam param);

    /**
     * 添加
     * @param param
     * @return
     */
    @Headers("Content-Type: application/json")
    @RequestMapping(value="/user/add", method= RequestMethod.POST)
    AddUserResult add(AddUserParam param);
}
