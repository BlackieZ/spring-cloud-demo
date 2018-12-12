package com.blackie.soa.client.model.base;

import lombok.Data;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Data
public class Response<T> {
    private T data;
    private int code;
    private String msg = "success";
    private Long timestamp = System.currentTimeMillis();
    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }
}
