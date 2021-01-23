package com.example.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZeroTower
 * @date 2021.1.21:0:33
 **/
@Data
@TableName("t_role")
//public class TRole implements Serializable, GrantedAuthority {
public class TRole implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("role_name")
    private String roleName;

    @TableField("note")
    private String note;

//    @Override
//    public String getAuthority() {
//        return roleName;
//    }
}
