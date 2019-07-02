package com.lingyun;

import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *   项目--lingyun
 * </p>
 *
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LingyunApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void contextLoads() {
        String admin = passwordEncoder.encode("admin");
        System.err.println(admin);
    }

}
