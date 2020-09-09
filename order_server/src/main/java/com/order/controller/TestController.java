package com.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.order.controller.TestController
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-09-05 16:33
 * @Version: 1.0
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "order server test!";
    }
}
