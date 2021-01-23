package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.TPermission;

import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 22:38
 * @Description
 * @Package com.example.security.service
 * @PROJECT security-simple
 **/
public interface TPermissionService extends IService<TPermission> {

    List<TPermission> selectByRoleId(Integer roleId);
}
