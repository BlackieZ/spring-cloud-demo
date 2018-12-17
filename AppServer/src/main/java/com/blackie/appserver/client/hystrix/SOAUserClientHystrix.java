package com.blackie.appserver.client.hystrix;

import com.blackie.appserver.client.SOAUserClient;
import com.blackie.soa.client.model.*;
import org.springframework.stereotype.Component;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Component
public class SOAUserClientHystrix implements SOAUserClient {
    @Override
    public UserLoginResult userLogin(UserLoginParam param) {
        UserLoginResult result = new UserLoginResult();
        result.setUserName("default");
        result.setUserId(0);
        return result;
    }

    @Override
    public GetUserDetailResult detail(GetUserDetailParam param) {
        GetUserDetailResult result = new GetUserDetailResult();
        result.setUserName("default");
        result.setUserId(0);
        return result;
    }

    @Override
    public AddUserResult add(AddUserParam param) {
        return null;
    }
}
