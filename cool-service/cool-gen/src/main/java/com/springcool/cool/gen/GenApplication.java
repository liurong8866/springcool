package com.springcool.cool.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springcool.cool.common.security.annotation.EnableCustomConfig;
import com.springcool.cool.common.security.annotation.EnableCustomFeignClients;
import com.springcool.cool.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 *
 * @author springcool
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableCustomFeignClients
@SpringBootApplication
public class GenApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
        System.out.println("\n(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ\n");
    }
}