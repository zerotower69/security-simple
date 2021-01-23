package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.TUserRole;

import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:56
 * @Description
 * @Package com.example.security.service
 * @PROJECT security-simple
 **/
public interface USerRoleService extends IService<TUserRole> {
    //id查找所有的映射用户
    public List<TUserRole> selectByUserId(Integer id);
}
