package com.example.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.TRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 15:07
 * @Description
 * @Package com.example.security.dao
 * @PROJECT security-simple
 **/
@Mapper
public interface TRoleDao extends BaseMapper<TRole> {
}
