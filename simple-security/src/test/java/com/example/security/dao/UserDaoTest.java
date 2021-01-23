package com.example.security.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:03
 * @Description
 * @Package com.example.security.dao
 * @PROJECT security-simple
 **/
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private TUserDao tUserDao;

    @Test
    void CURD(){
        System.out.println(tUserDao.selectList(null).toString());
    }
}
