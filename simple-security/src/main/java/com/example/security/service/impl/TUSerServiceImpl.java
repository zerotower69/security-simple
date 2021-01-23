package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.dao.TUserDao;
import com.example.security.entity.TUser;
import com.example.security.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:01
 * @Description
 * @Package com.example.security.service.impl
 * @PROJECT security-simple
 **/
@Service("TUserService")
public class TUSerServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {
    @Autowired
    private TUserDao tUserDao;

    @Override
    public TUser selectById(Integer id) {
      return   tUserDao.selectById(id);
    }

    @Override
    public TUser selectByUsername(String username) {
        QueryWrapper<TUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return tUserDao.selectOne(queryWrapper);
    }
}
