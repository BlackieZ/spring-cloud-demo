package com.blackie.soa.controller;

import com.blackie.soa.client.model.AddUserParam;
import com.blackie.soa.client.model.AddUserResult;
import com.blackie.soa.client.model.GetUserDetailParam;
import com.blackie.soa.client.model.GetUserDetailResult;
import com.blackie.soa.client.model.base.Response;
import com.blackie.soa.service.UserServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
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
    static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserServerService userServerService;

    /**
     * 请求方式类型content-type: application/json
     * 注意：使用gateway时，需要用post方式请求
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/detail")
    public GetUserDetailResult detail(@RequestBody GetUserDetailParam param){
        GetUserDetailParam detailParam = new GetUserDetailParam();
        detailParam.setUserId(param.getUserId());
        GetUserDetailResult result = userServerService.detail(detailParam);
        return result;
    }

    /**
     * get 方法
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public Response<AddUserResult> add(AddUserParam param){
        log.info(param.toString());
        AddUserResult result = userServerService.add(param);
        return new Response<>(result);
    }
}
