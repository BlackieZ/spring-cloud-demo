package com.blackie.soa.service.impl;

import com.blackie.soa.client.model.*;
import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.client.model.po.test.mbg.UserTestExample;
import com.blackie.soa.dal.test.read.custom.UserTestReadDao;
import com.blackie.soa.dal.test.write.custom.UserTestWriteDao;
import com.blackie.soa.service.UserServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Service
public class UserServerServiceImpl implements UserServerService {
    @Autowired
    private UserTestReadDao userTestReadDao;
    @Autowired
    private UserTestWriteDao userTestWriteDao;

    @Override
    public UserLoginResult userLogin(UserLoginParam param) {
        UserLoginResult result = new UserLoginResult();
        return result;
    }

    @Override
    public GetUserDetailResult detail(GetUserDetailParam param) {
        UserTestExample userTestExample = new UserTestExample();
        userTestExample.or().andIdEqualTo(param.getUserId());
        userTestExample.setLimit(1);
        userTestExample.setOffset(0);
        List<UserTest> userTests = userTestReadDao.selectByExample(userTestExample);
        GetUserDetailResult result = new GetUserDetailResult();
        if(userTests.size() > 0){
            result.setUserId(userTests.get(0).getId());
            result.setUserName(userTests.get(0).getName());
        }
        return result;
    }

    @Override
    public AddUserResult add(AddUserParam param) {
        AddUserResult result = new AddUserResult();
        UserTest userTest = new UserTest();
        userTest.setMobile(param.getMobile());
        userTest.setName(param.getName());
        userTestWriteDao.insertSelective(userTest);
        result.setUserId(userTest.getId());
        return result;
    }
}
