package com.lingyun.security;

import com.lingyun.dao.LyUserDao;
import com.lingyun.service.impl.LyUserDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${security.header}")
    private String header;

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private LyUserDao userDao;
    @Autowired
    private LyUserDetailService detailService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) res;

        String header = request.getHeader(this.header);

        if(StringUtils.isNotBlank(header)){
            String username=tokenUtil.getUsernameFromToken(header);
            if(StringUtils.isNotBlank(username)&&SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails details = detailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }


        chain.doFilter(request,response);
    }
}
