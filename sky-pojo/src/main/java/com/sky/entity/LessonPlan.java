package com.sky.entity;

import lombok.Data;

@Data
public class LessonPlan {
    private Long id;                // 教案ID
    private String lessonPlanName;  // 教案名称
    private Long unitId;            // 单元ID，关联到单元表
    private String teachingContent; // 教学内容（文本）
    private String teachingMethod;  // 教学方法（文本）
    private String teachingGoal;    // 教学目标（文本）
    private String teachingKeyPoint; // 教学重点（文本）
    private String teachingDifficult; // 教学难点（文本）

    // 教学过程，分为导入、讲解、总结、拓展
    private String introduction;    // 导入部分（文本）
    private String explanation;     // 讲解部分（文本）
    private String conclusion;      // 总结部分（文本）
    private String expansion;       // 拓展部分（文本）

    private String createdAt;       // 创建时间
    private String updatedAt;       // 更新时间

    // 新增字段：创建方式（手写输入 / 语音转录）
    private String creationMethod;  // 创建方式（输入/转录）
}
