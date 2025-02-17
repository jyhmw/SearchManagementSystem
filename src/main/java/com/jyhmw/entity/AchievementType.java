package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 科研成果类型
 */
@TableName("achievement_type")
@Data
public class AchievementType {
    @TableId(type = IdType.AUTO)
    private Integer achievementTypeId;

    private String typeName;

    private String typeDescription;
}
