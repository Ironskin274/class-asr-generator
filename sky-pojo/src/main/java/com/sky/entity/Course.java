package com.sky.entity;

import lombok.Data;

@Data
public class Course {
    private Long id;              // 课程ID
    private String courseName;    // 课程名称
    private String courseCode;    // 课程编号
    private String courseTarget;  // 授课对象（本科/研究生）
    private String courseType;    // 课程类型（必修/选修）
    private int creditHours;      // 学时数
    private double credits;       // 学分数
    private String status;        // 课程状态（启用/禁用）
    private Long userId;          // 用户ID，关联到用户表
    private String createdAt;     // 创建时间
    private String updatedAt;     // 更新时间
}
