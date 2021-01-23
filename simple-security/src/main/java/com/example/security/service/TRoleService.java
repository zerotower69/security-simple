package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.TRole;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:55
 * @Description
 * @Package com.example.security.service
 * @PROJECT security-simple
 **/
public interface TRoleService extends IService<TRole> {
    //id查找角色
    public TRole selectById(Integer id);
    //用户名查找角色
    public TRole selectByRoleName(String roleName);
}
