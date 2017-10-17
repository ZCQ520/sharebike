package com.wzu.sharebike.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jack
 * @date 2017/10/17   9:51
 */
public interface UserController {


    @GetMapping("/hello")
    public String getHello();

}
