package com.lingyun.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UnauthenticationEntryPoint implements AuthenticationEntryPoint {
    @Value("${security.header}")
    private String tokenHeader;
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if(httpServletRequest.getMethod().equals("OPTIONS")){
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE,PATCH");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setStatus(200);
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + tokenHeader);
            //response.setHeader("Access-Control-Allow-Origin", "http://petstore.swagger.io");
            httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN");
        }else{
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access Denied");
        }
    }
}
