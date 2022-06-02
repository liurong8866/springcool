package com.springcool.cool.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springcool.cool.common.security.annotation.EnableCustomConfig;
import com.springcool.cool.common.security.annotation.EnableCustomFeignClients;
import com.springcool.cool.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 *
 * @author springcool
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableCustomFeignClients
@SpringBootApplication
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
        System.out.println("\n(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ\n");
    }
}
