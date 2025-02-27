package com.sky.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String courseName;
    private String courseCode;
    private String courseTarget; // 授课对象（本科/研究生）
    private String courseType; // 课程类型（必修/选修）
    private Integer creditHours; // 学时数
    private Integer credits; // 学分数

}
