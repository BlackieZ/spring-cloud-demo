package com.blackie.appserver.controller;

import com.blackie.appserver.client.SOAUserClient;
import com.blackie.common.model.Response;
import com.blackie.soa.client.model.GetUserDetailParam;
import com.blackie.soa.client.model.GetUserDetailResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by BlackieZ 365227949@qq.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private SOAUserClient userClient;

    @ResponseBody
    @RequestMapping("/detail")
    public Response<GetUserDetailResult> getUserInfo(Integer id){
        GetUserDetailParam detailParam = new GetUserDetailParam();
        detailParam.setUserId(id);
        GetUserDetailResult result = userClient.detail(detailParam);
        return new Response<>(result);
    }

}
