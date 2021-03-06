package com.wzu.sharebike.common.emum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2017/10/18.
 */
public enum ResultCode {
    CODE_200(200, "访问成功"),
    CODE_203(203, "访问成功"),
    CODE_204(204, "访问成功"),
    CODE_401(401, "非法请求，参数错误"),
    CODE_402(402, "未授权，token过期或无效"),
    CODE_403(403, "Method使用错误，请查看API"),
    CODE_404(404, "找不到访问地址"),
    CODE_406(406, "没有权限访问"),
    CODE_500(500, "系统内部错误"),
    CODE_501(501, "对象已存在，请检测唯一性"),
    CODE_502(502, "当前版本与服务器版本不一致,请更新应用"),
    CODE_503(503, "对象不存在，请检测请求参数");




    public Integer code;
    public String msg;

    ResultCode(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    protected static Map<Integer, String> codeMessageMap;

    static {
        codeMessageMap = new HashMap<>();
        for (ResultCode resultCode : ResultCode.values()) {
            codeMessageMap.put(resultCode.code, resultCode.msg);
        }
    }

    public static String findMessageByCode(Integer code) {
        if (codeMessageMap != null) {
            return codeMessageMap.get(code);
        }
        return "";
    }

}
