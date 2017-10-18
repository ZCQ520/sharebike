package com.wzu.sharebike.common.controller;

import com.wzu.sharebike.common.ResultDTO;
import com.wzu.sharebike.common.emum.ResultCode;
import com.wzu.sharebike.common.mybatis.PagingResult;
import com.wzu.sharebike.common.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author jack
 * @date 2017/10/17   18:19
 */
public abstract class BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    protected ResultDTO success() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(ResultCode.CODE_200.code);
        return resultDTO;
    }

    protected ResultDTO success(Object data) {
        ResultDTO resultDTO;
        if (data instanceof PagingResult) {
            resultDTO = new ResultDTO();
            resultDTO.page((PagingResult) data);
        } else if (data instanceof Integer) {
            resultDTO = new ResultDTO();
            resultDTO.code((Integer) data);
            resultDTO.message(ResultCode.findMessageByCode((Integer) data));
            return resultDTO;
        } else {
            resultDTO = new ResultDTO(data);
        }
        resultDTO.code(ResultCode.CODE_200.code);
        return resultDTO;
    }

    protected ResultDTO fail(int code) {
        return fail(code, ResultCode.findMessageByCode(code));
    }

    protected ResultDTO fail(int code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code(code);
        resultDTO.message(message);
        return resultDTO;
    }

    /**
     * 操作完数据库后直接返回200或500
     *
     * @param isSuccess
     * @return
     */
    protected ResultDTO result(boolean isSuccess) {
        if (isSuccess) {
            return success();
        }
        return fail(ResultCode.CODE_500.code);
    }

    /**
     * 非空参数检测 当存在非空参数为空时返回 401
     *
     * @param arg
     */
    protected boolean checkParaNULL(Object... arg) {
        if (arg != null) {
            for (int i = 0; i < arg.length; i++) {
                if (null == arg[i] || "".equals(arg[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * pojo对象转换为map集合
     *
     * @param object
     * @return
     */
    protected Map<String, Object> pojoToMap(Object object) {
        return BeanUtil.bean2Map(object);
    }

    protected String getLoginUserId() {
        return "899867113811021824";
    }


}
