package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 科研成果评审表
 */
@TableName("review")
@Data
public class Review {
    @TableId(type = IdType.AUTO)
    private Integer reviewId;

    @TableField("achievement_id")
    private Integer achievementId; // 外键字段直接存储ID

    @TableField("reviewer_id")
    private Integer reviewerId; // 外键字段直接存储ID

    private String reviewOpinion;

    private Date reviewTime;
}
