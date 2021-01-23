package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.TUser;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:00
 * @Description
 * @Package com.example.security.service
 * @PROJECT security-simple
 **/
public interface TUserService extends IService<TUser> {

    //Id查找用户
    public TUser selectById(Integer id);
    //用户名查找用户
    public TUser selectByUsername(String username);

}
