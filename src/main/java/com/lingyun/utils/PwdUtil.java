package com.lingyun.utils;

import org.apache.commons.lang3.StringUtils;

public class PwdUtil {

    /**
     * 密码匹配
     * @param password
     * @param md5Password
     * @return
     */
    public static Boolean match(String password,String md5Password){
        if(StringUtils.isBlank(password)){
            return false;
        }
        String pwd = MD5Utils.MD5(password);
        if(pwd.equals(md5Password)){
            return true;
        }
        return false;
    }
    /**
     * 密码加密
     */
    public static String encode(String password){
        if(StringUtils.isBlank(password)){
            return "";
        }
        return MD5Utils.MD5(password);
    }

    public static void main(String[] args){
    }
}
