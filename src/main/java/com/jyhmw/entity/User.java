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

    private String username;

    private String password;

    private String name;

    private String contact;

    private String school;

    @TableField("role_id")
    private Integer roleId; // 外键字段直接存储ID
}
