package com.springcool.tenant;

import com.springcool.common.security.annotation.EnableCustomConfig;
import com.springcool.common.security.annotation.EnableCustomFeignClients;
import com.springcool.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 租户模块
 *
 * @author springcool
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableCustomFeignClients
@SpringBootApplication
public class TenantApplication {
    public static void main(String[] args) {
        SpringApplication.run(TenantApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  租户管理模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}