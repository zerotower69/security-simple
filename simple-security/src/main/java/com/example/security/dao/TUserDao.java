package com.example.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 13:56
 * @Description
 * @Package com.example.security.dao
 * @PROJECT security-simple
 **/
@Mapper
public interface TUserDao extends BaseMapper<TUser> {

}
