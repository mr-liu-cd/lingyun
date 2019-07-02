package com.lingyun.exception;



/**
 * 自定义异常处理
 * Created by van on 2017/4/19.
 */
public class ObjectException extends RuntimeException {
    private Integer status;


    public ObjectException(int code, String msg) {
        super(msg);
        this.status = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
