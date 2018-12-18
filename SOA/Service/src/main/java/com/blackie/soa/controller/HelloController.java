package com.blackie.soa.controller;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@RestController
@RequestMapping("/")
public class HelloController {
    static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private ApplicationInfoManager applicationInfoManager;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public String down(){
        InstanceInfo info = applicationInfoManager.getInfo();
        String instanceId = info.getInstanceId();
        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
        applicationInfoManager.refreshDataCenterInfoIfRequired();
        applicationInfoManager.refreshLeaseInfoIfRequired();
        return instanceId + " DOWN";
    }

    @RequestMapping(value = "/up", method = RequestMethod.GET)
    public String up(){
        InstanceInfo info = applicationInfoManager.getInfo();
        String instanceId = info.getInstanceId();
        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
        applicationInfoManager.refreshDataCenterInfoIfRequired();
        applicationInfoManager.refreshLeaseInfoIfRequired();
        return instanceId + " UP";
    }


}
