package com.lingyun.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    @Value("${security.token.head}")
    private String head;

    public  String getUsernameFromToken(String token){
        if(StringUtils.isNotBlank(token)&&token.length()>head.length()){
            return token.substring(head.length());
        }
        return null;
    }

    public String createToken(String username){
        return head+username;
    }

}
