package com.example.security.security;

import com.example.security.entity.TPermission;
import com.example.security.entity.TUser;
import com.example.security.service.TPermissionService;
import com.example.security.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 22:48
 * @Description
 * @Package com.example.security.security
 * @PROJECT security-simple
 **/
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private TPermissionService permissionService;
    @Autowired
    private TRoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        User user=(User)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        //遍历所有的角色
        for(GrantedAuthority authority:authorities){
            String roleName=authority.getAuthority();
            Integer roleId = roleService.selectByRoleName(roleName).getId();
            //得到角色所有的权限
            List<TPermission> permissionList=permissionService.selectByRoleId(roleId);

            //遍历权限
            for(TPermission permission:permissionList){
                //获取权限集
                List permissions=permission.getPermissions();
                //如果访问的url和用户的权限符合，咋们返回true
                if(targetUrl.equals(permission.getUrl())
                        && permissions.contains(targetPermission) ){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return  false;
    }
}
