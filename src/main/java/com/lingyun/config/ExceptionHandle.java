package com.lingyun.config;

import com.lingyun.exception.ObjectException;
import com.lingyun.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用来捕获异常，统一返回信息
 * Created by van on 2017/4/19.
 * Email:icaishaohua@gmail.com
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handleException(Exception e) {
        logger.error("【系统异常】{}", e);
        return Response.error(403, String.valueOf(e));
    }

    @ExceptionHandler(value = ObjectException.class)
    @ResponseBody
    public Response handleObjectException(ObjectException e) {
        return Response.error(e.getStatus(), e.getMessage());
    }

}
