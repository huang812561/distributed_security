package com.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.order.controller.OrderController
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-24 13:29
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/query")
    @PreAuthorize(value = "hasAuthority('p1')")//拥有p1权限的人才可访问
    public String order(){
        return "order server";
    }
}
