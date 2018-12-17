package com.blackie.appserver.client;

import com.blackie.appserver.client.hystrix.SOAUserClientHystrix;
import com.blackie.soa.client.api.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@FeignClient(name = "soa",fallback = SOAUserClientHystrix.class)
public interface SOAUserClient extends UserService{
}
