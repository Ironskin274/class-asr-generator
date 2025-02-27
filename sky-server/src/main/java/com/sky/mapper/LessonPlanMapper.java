package com.sky.mapper;

import com.sky.entity.LessonPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LessonPlanMapper {

    // 添加教案
    void addLessonPlan(LessonPlan lessonPlan);

    // 根据单元ID查询教案列表
    List<LessonPlan> getLessonPlanListByUnitId(@Param("unitId") Long unitId);

    // 根据教案ID查询教案详情
    LessonPlan getLessonPlanById(@Param("lessonPlanId") Long lessonPlanId);

    // 更新教案信息
    void updateLessonPlan(LessonPlan lessonPlan);

    // 删除教案
    void deleteLessonPlanByIds(@Param("ids") List<Long> ids);
}
