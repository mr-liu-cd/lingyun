package com.lingyun;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *   项目--lingyun
 * </p>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.lingyun.dao")
public class LingyunApplication{

public static void main(String[]args){
        SpringApplication.run(LingyunApplication.class,args);
        }

}
