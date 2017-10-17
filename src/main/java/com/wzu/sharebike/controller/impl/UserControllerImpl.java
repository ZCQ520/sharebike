package com.wzu.sharebike.controller.impl;

import com.wzu.sharebike.controller.UserController;
import com.wzu.sharebike.pojo.User;
import com.wzu.sharebike.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2017/10/17   9:52
 */
@RestController
public class UserControllerImpl implements UserController {

    @Resource
    private UserService userService;

    @Override
    public String getHello() {
        User user = new User();
        user.setAge(11);
        user.setId("1111");
        user.setName("1111");
        return userService.insertUser(user)+"";
    }
}
