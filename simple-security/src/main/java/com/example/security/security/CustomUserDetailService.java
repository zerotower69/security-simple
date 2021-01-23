package com.example.security.security;

import com.example.security.entity.TRole;
import com.example.security.entity.TUser;
import com.example.security.entity.TUserRole;
import com.example.security.service.TRoleService;
import com.example.security.service.TUserService;
import com.example.security.service.USerRoleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 15:12
 * @Description  实现自定义的用户服务
 * @Package com.example.security.security
 * @PROJECT security-simple
 **/
@Service("userDetailsService")
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    //注入用户、角色以及映射服务
    @Autowired
    private TUserService userService;
    @Autowired
    private TRoleService roleService;
    @Autowired
    private USerRoleService uSerRoleService;

    private static Logger logger=LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("检验的用户名={}",s);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        //从数据库中取出用户信息
        TUser user=userService.selectByUsername(s);
        logger.info("查到的用户信息:\n{}",user.toString());
        //判断用户是否存在
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        //权限授予
        List<TUserRole> userRoleList=uSerRoleService.selectByUserId(user.getId());
        //所有映射集打印
        logger.info("用户角色\n{}",userRoleList.toString());
        userRoleList.forEach(tUserRole -> {
            TRole tRole=roleService.selectById(tUserRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(tRole.getRoleName()));
        });
        //打印权限集合
        logger.info("权限\n{}",authorities.toString());
        //返回USerDetails实现类
        return new User(user.getUsername(),user.getPassword(),authorities);
    }


}
