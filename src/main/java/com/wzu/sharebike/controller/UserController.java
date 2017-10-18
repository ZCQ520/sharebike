package com.wzu.sharebike.controller;

import com.wzu.sharebike.common.ResultDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jack
 * @date 2017/10/17   9:51
 */
@Api(value = "userOper", tags = {"用户管理"}, description = "UserController", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(name = "操作员管理控制器", value = "/api/v1/admin")
public interface UserController {


    @ApiOperation(value = "[doc]hello", tags = {"hello"}, notes = "hello")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "data", response = ApiResponse.class)})
    public ResultDTO getHello(@ApiParam(required = true, name = "userId", value = "账户id") @RequestParam String userId);

    @ApiOperation(value = "[doc]注册用户", tags = {"注册用户"}, notes = "注册用户")
    @RequestMapping(method = RequestMethod.POST, value = "/registerOrLogin")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "data", response = ApiResponse.class)})
    public ResultDTO registerOrLogin(@ApiParam(required = true, name = "phoneNumber", value = "手机号") @RequestParam String phoneNumber,
                                  @ApiParam(required = true, name = "checkCode", value = "验证码") @RequestParam String checkCode);

}
