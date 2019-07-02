package com.lingyun.config;


import com.lingyun.security.AuthticationTokenFilter;
import com.lingyun.security.UnauthenticationEntryPoint;
import com.lingyun.service.impl.LyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LyUserDetailService lyUserDetailService;

    @Autowired
    private UnauthenticationEntryPoint unauthenticationEntryPoint;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(lyUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthticationTokenFilter authticationTokenFilterBean() throws Exception{
        AuthticationTokenFilter authticationTokenFilter = new AuthticationTokenFilter();
        authticationTokenFilter.setAuthenticationManager(authenticationManager());
        return authticationTokenFilter;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/lingyun/user/admin_user_login/**").permitAll()
                .antMatchers("/lingyun/table/**").permitAll()
                .antMatchers("/lingyun/table_row/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
        http.headers().cacheControl();

        http.addFilterBefore(authticationTokenFilterBean(),UsernamePasswordAuthenticationFilter.class);
    }
}
