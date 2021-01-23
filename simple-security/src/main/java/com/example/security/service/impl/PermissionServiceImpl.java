package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.dao.TPermissionDao;
import com.example.security.entity.TPermission;
import com.example.security.service.TPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 22:38
 * @Description
 * @Package com.example.security.service.impl
 * @PROJECT security-simple
 **/
@Service("TPermissionService")
public class PermissionServiceImpl extends ServiceImpl<TPermissionDao, TPermission> implements TPermissionService {

    @Autowired
    private TPermissionDao permissionDao;
    @Override
    public List<TPermission> selectByRoleId(Integer roleId) {
        QueryWrapper<TPermission> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        return  permissionDao.selectList(queryWrapper);
    }
}
