package com.springcool.cool.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springcool.cool.common.security.annotation.EnableCustomConfig;
import com.springcool.cool.common.security.annotation.EnableCustomFeignClients;
import com.springcool.cool.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 *
 * @author springcool
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableCustomFeignClients
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("\n(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ\n");
    }
}