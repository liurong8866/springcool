package com.springcool.cool.tenant;

import com.springcool.cool.common.security.annotation.EnableCustomConfig;
import com.springcool.cool.common.security.annotation.EnableCustomFeignClients;
import com.springcool.cool.common.swagger.annotation.EnableCustomSwagger2;
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
        System.out.println("\n(♥◠‿◠)ﾉﾞ  租户管理模块启动成功   ლ(´ڡ`ლ)ﾞ\n");
    }
}