package com.example.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.TPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 22:37
 * @Description
 * @Package com.example.security.dao
 * @PROJECT security-simple
 **/
@Mapper
public interface TPermissionDao extends BaseMapper<TPermission> {
}
