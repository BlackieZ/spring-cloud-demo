package com.blackie.soa.controller;

import com.blackie.soa.client.model.*;
import com.blackie.soa.client.model.base.Response;
import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.service.UserServerService;
import org.springframework.web.bind.annotation.*;

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
    public GetUserDetailResult detail(@RequestBody GetUserDetailParam param){
        GetUserDetailParam detailParam = new GetUserDetailParam();
        detailParam.setUserId(param.getUserId());
        GetUserDetailResult result = userServerService.detail(detailParam);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/add")
    public Response<AddUserResult> add(AddUserParam param){
        AddUserResult result = userServerService.add(param);
        return new Response<>(result);
    }
}
