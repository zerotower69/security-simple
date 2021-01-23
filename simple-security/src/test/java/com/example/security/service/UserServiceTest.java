package com.example.security.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:10
 * @Description
 * @Package com.example.security.service
 * @PROJECT security-simple
 **/
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private TUserService userService;

    @Test
    void CURD(){
        System.out.println(userService.list().toString());
    }
}
