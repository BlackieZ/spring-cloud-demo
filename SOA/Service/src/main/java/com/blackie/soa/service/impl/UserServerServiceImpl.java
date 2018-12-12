package com.blackie.soa.service.impl;

import com.blackie.soa.client.model.UserLoginParam;
import com.blackie.soa.client.model.UserLoginResult;
import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.client.model.po.test.mbg.UserTestExample;
import com.blackie.soa.dal.test.read.custom.UserTestReadDao;
import com.blackie.soa.service.UserServerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Service
public class UserServerServiceImpl implements UserServerService {
    @Resource
    private UserTestReadDao userTestReadDao;

    @Override
    public UserLoginResult userLogin(UserLoginParam param) {
        UserTestExample userTestExample = new UserTestExample();
        userTestExample.or().andIdEqualTo(param.getUserId());
        userTestExample.setLimit(1);
        userTestExample.setOffset(0);
        List<UserTest> userTests = userTestReadDao.selectByExample(userTestExample);
        UserLoginResult result = new UserLoginResult();
        if(userTests.size() > 0){
            result.setUserId(userTests.get(0).getId());
            result.setUserName(userTests.get(0).getName());
        }
        return result;
    }
}
