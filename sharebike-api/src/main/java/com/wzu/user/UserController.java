package com.wzu.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @date 2017/10/16   18:42
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
}
