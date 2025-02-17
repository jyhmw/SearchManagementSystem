package com.jyhmw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 科研成果相关文件表
 */
@TableName("file")
@Data
public class File {
    @TableId(type = IdType.AUTO)  // 主键自增
    private Integer fileId;

    @TableField("achievement_id")  // 外键字段，关联科研成果表
    private Integer achievementId;

    @TableField("file_name")  // 文件名
    private String fileName;

    @TableField("file_path")  // 文件存储路径
    private String filePath;

    @TableField("file_type")  // 文件类型（如PDF、Word、Excel）
    private String fileType;

    @TableField("upload_time")  // 文件上传时间
    private Date uploadTime;
}
