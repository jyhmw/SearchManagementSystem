package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 科研成果学科表
 */
@TableName
@Data
public class Subject {
    @TableId(type = IdType.AUTO)
    private Integer subjectId;

    private String subjectName;

    private String subjectCode;
}
