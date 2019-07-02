package com.lingyun.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 返回数据
 * </p>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
public class Response extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public Response() {
        put("code", 200);
    }

    public static Response error() {
        return error(500, "未知异常，请联系管理员" );
    }

    public static Response error(String msg) {
        return error(500, msg);
    }

    public static Response error(int code, String msg) {
        Response response = new Response();
        response.put("code", code);
        response.put("msg", msg);
        return response;
    }

    public static Response ok(String msg) {
        Response response = new Response();
        response.put("msg", msg);
        return response;
    }

    public static Response ok(Map<String, Object> map) {
        Response response = new Response();
        response.putAll(map);
        return response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Response ok() {
        return new Response();
    }

    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
