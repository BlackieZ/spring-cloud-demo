package com.blackie.soa.client.api;


import com.blackie.soa.client.model.*;

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

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    GetUserDetailResult detail(GetUserDetailParam param);
    /**
     * 获取用户详情
     * @param param
     * @return
     */
    AddUserResult add(AddUserParam param);
}
