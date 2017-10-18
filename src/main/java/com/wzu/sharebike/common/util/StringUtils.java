package com.wzu.sharebike.common.util;

/**
 * @author jack
 * @date 2017/10/17   18:37
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    /**
     * 将字符串的第index个字符转为大写（一般用于将首字母转成大写）
     * @param source
     * @param index
     * @return
     */
    public static String letterToUpperCase(String source, int index) {
        String firstCharStr = String.valueOf(source.charAt(0));
        StringBuilder builder = new StringBuilder(source);
        builder.replace(index, index + 1, firstCharStr.toUpperCase());
        return builder.toString();
    }

    /**
     * 判断字符串参数是否含非空值
     * @param strings 字符串参数
     * @return 字符串参数全为空返回Null,至少一个不为空返回true
     */
    public static boolean atLeastOneNotNull(String...strings){
        for (String str: strings) {
            if(str == null || str.length() == 0){
                continue;
            }else {
                return true;
            }
        }
        return false;
    }

    public static String nullStringToEmpty(String str){
        if(str == null){
            return "";
        }
        return str;
    }
}
