package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 */
@TableName("user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username; //用户名

    private String password; //密码

    private String name;  //名字

    private String contact;  //联系方式

    private String school;  //学校

    @TableField("role_id")
    private Integer roleId; // 外键字段直接存储ID
}
