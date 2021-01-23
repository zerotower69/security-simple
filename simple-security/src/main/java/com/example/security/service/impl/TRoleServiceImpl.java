package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.dao.TRoleDao;
import com.example.security.entity.TRole;
import com.example.security.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 15:06
 * @Description
 * @Package com.example.security.service.impl
 * @PROJECT security-simple
 **/
@Service("TRoleService")
public class TRoleServiceImpl extends ServiceImpl<TRoleDao, TRole> implements TRoleService {

    @Autowired
    private TRoleDao roleDao;
    @Override
    public TRole selectById(Integer id) {
        return roleDao.selectById(id);
    }

    @Override
    public TRole selectByRoleName(String roleName) {
        QueryWrapper<TRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("role_name",roleName);
        return roleDao.selectOne(queryWrapper);
    }
}
