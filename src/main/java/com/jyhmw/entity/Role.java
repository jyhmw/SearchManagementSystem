package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色表
 */
@TableName("role")
@Data
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleDescription;
}
