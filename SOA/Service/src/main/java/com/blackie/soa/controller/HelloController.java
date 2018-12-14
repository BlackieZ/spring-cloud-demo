package com.blackie.soa.controller;

import com.blackie.soa.client.model.*;
import com.blackie.soa.client.model.base.Response;
import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.service.UserServerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@RestController
@RequestMapping("/user")
public class HelloController {
    @Resource
    private UserServerService userServerService;

    @ResponseBody
    @RequestMapping("/detail")
    public Response<GetUserDetailResult> getUserInfo(Integer id){
        GetUserDetailParam detailParam = new GetUserDetailParam();
        detailParam.setUserId(id);
        GetUserDetailResult result = userServerService.detail(detailParam);
        return new Response<>(result);
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response<AddUserResult> add(String name,String mobile){
        AddUserParam addUserParam = new AddUserParam();
        addUserParam.setMobile(mobile);
        addUserParam.setName(name);
        AddUserResult result = userServerService.add(addUserParam);
        return new Response<>(result);
    }
}
