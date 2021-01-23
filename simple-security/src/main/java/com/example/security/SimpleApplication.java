package com.example.security;

import com.example.security.config.VerifyServlet;
import org.checkerframework.common.aliasing.qual.MaybeAliased;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 13:48
 * @Description
 * @Package com.example.security
 * @PROJECT security-simple
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.security.dao")
public class SimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class,args);
    }
    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}
