package com.hgq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.hgq.controller.AuthController
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-18 17:19
 * @Version: 1.0
 */
@RestController
public class AuthController {

    @RequestMapping("/hello")
    public String index(){
        return "hello auth serve";
    }

}
