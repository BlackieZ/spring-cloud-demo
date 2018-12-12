package com.blackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Controller
@RequestMapping("/")
public class H5 {
    @RequestMapping(value = {"/"})
    public String h5() {
        return "index" ;
    }
}
