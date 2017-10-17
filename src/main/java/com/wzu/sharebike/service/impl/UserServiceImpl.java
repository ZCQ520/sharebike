package com.wzu.sharebike.service.impl;

import com.wzu.sharebike.mapper.UserMapper;
import com.wzu.sharebike.pojo.User;
import com.wzu.sharebike.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2017/10/17   13:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insertUser(User user) {
        return userMapper.insert(user)==1?true:false;
    }
}
