package com.example.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serializable;
import java.util.List;

/**
 * @author ZeroTower
 * @date 2021.1.21:0:13
 **/
@Data
@TableName("t_user")
//public class TUser implements UserDetails, Serializable {
public class TUser implements  Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("pwd")
    private String password;

    @TableField("available")
    private boolean available;

    @TableField(exist = false)
    List<TRole> tRoleList=null;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorityList=new ArrayList<>();
//        if(CollectionUtils.isEmpty(tRoleList)){
//            for (TRole tRole : tRoleList) {
//                authorityList.add(new SimpleGrantedAuthority(tRole.getId().toString()));
//            }
//        }
//        return tRoleList;
//    }
//
//    //密码加密
//    @Override
//    public String getPassword() {
//        return new BCryptPasswordEncoder().encode(password);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
