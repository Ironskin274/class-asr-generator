package com.sky.service;

import com.sky.entity.LessonPlan;
import com.sky.dto.LessonPlanDTO;

import java.util.List;

public interface LessonPlanService {

    // 创建教案
    void createLessonPlan(LessonPlanDTO lessonPlanDTO);

    // 获取单元下的所有教案
    List<LessonPlan> getLessonPlanListByUnitId(Long unitId);

    // 获取教案详情
    LessonPlan getLessonPlanById(Long lessonPlanId);

    // 更新教案
    void updateLessonPlan(LessonPlanDTO lessonPlanDTO);

    void deleteLessonPlan(List<Long> ids);
}
