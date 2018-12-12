package com.blackie.soa.client.model;

import lombok.Data;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Data
public class UserLoginParam {
    private String account;
    private String pwd;
    private Integer userId;
}
