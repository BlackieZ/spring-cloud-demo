package com.blackie.soa.controller;

import com.blackie.soa.client.model.UserLoginParam;
import com.blackie.soa.client.model.UserLoginResult;
import com.blackie.soa.client.model.base.Response;
import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.service.UserServerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@RestController
public class HelloController {
    @Resource
    private UserServerService userServerService;

    @ResponseBody
    @RequestMapping("/user")
    public Response<UserLoginResult> getUserInfo(Integer id){
        UserLoginParam loginParam = new UserLoginParam();
        loginParam.setUserId(id);
        UserLoginResult result = userServerService.userLogin(loginParam);
        return new Response<>(result);
    }
}
