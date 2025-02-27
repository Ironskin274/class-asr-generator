package com.sky.entity;

import lombok.Data;

@Data
public class Unit {
    private Long id;              // 单元ID
    private String unitName;      // 单元名称
    private Long courseId;        // 课程ID，关联到课程表
    private String createdAt;     // 创建时间
    private String updatedAt;     // 更新时间
}
