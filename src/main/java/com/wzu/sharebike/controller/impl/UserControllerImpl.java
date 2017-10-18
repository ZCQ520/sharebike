package com.wzu.sharebike.controller.impl;

import com.wzu.sharebike.common.ResultDTO;
import com.wzu.sharebike.common.controller.BaseController;
import com.wzu.sharebike.common.emum.ResultCode;
import com.wzu.sharebike.controller.UserController;
import com.wzu.sharebike.pojo.User;
import com.wzu.sharebike.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2017/10/17   9:52
 */
@RestController
public class UserControllerImpl extends BaseController implements UserController {

    @Resource
    private UserService userService;

    @Override
    public ResultDTO getHello(@ApiParam(required = true, name = "userId", value = "账户id") @RequestParam String userId) {
        User user = new User();
        user.setAge(11);
        user.setId("1111");
        user.setName("1111");
        return success(userService.insertUser(user)+"");
    }

    @Override
    public ResultDTO registerOrLogin(@ApiParam(required = true, name = "phoneNumber", value = "手机号") @RequestParam String phoneNumber,
                                  @ApiParam(required = true, name = "checkCode", value = "验证码") @RequestParam String checkCode) {

        //TODO 暂定验证码为1234
        if (checkCode!=null&&checkCode.equals("1234")){


        }
        return fail(ResultCode.CODE_401.code,"校验码错误");
    }
}
