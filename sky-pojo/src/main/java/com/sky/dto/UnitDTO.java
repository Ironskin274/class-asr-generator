package com.sky.dto;

import lombok.Data;

@Data
public class UnitDTO {
    private Long id;              // 单元ID
    private String unitName;      // 单元名称
    private Long courseId;        // 课程ID
}
