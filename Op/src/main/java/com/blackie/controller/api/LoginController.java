package com.blackie.controller.api;

import com.blackie.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController {
    @Value("${env.password}")
    private String password;

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public Response<String> login() {
        Response<String> response = new Response<>();
        response.setData(password);
        return response;
    }
}
