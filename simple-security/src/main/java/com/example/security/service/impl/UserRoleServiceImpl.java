package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.dao.UserRoleDao;
import com.example.security.entity.TUserRole;
import com.example.security.service.USerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 15:09
 * @Description
 * @Package com.example.security.service.impl
 * @PROJECT security-simple
 **/
@Service("UserRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, TUserRole> implements USerRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public List<TUserRole> selectByUserId(Integer id) {
        QueryWrapper<TUserRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        return userRoleDao.selectList(queryWrapper);
    }
}
