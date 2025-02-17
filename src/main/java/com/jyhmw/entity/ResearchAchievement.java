package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 科研成果表
 */
@TableName("research_achievement")
@Data
public class ResearchAchievement {
    @TableId(type = IdType.AUTO)
    private Integer achievementId;

    private String achievementName;

    private String achievementDescription;

    @TableField("authors")
    private String authors; // JSON格式存储作者列表

    @TableField("publish_time")
    private Date publishTime;

    @TableField("achievement_type_id")
    private Integer achievementTypeId; // 外键字段直接存储ID

    @TableField("subject_id")
    private Integer subjectId; // 外键字段直接存储ID

    private Boolean isPublic; //是否公开
}
