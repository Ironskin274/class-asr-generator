package com.sky.service.impl;

import com.sky.dto.LessonPlanDTO;
import com.sky.entity.LessonPlan;
import com.sky.exception.LessonPlanNotFoundException;
import com.sky.mapper.LessonPlanMapper;
import com.sky.service.LessonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonPlanServiceImpl implements LessonPlanService {

    @Autowired
    private LessonPlanMapper lessonPlanMapper;

    /**
     * 创建教案（为特定单元添加）
     */
    @Override
    public void createLessonPlan(LessonPlanDTO lessonPlanDTO) {
        LessonPlan lessonPlan = new LessonPlan();
        lessonPlan.setLessonPlanName(lessonPlanDTO.getLessonPlanName());
        lessonPlan.setUnitId(lessonPlanDTO.getUnitId());
        lessonPlan.setTeachingContent(lessonPlanDTO.getTeachingContent());
        lessonPlan.setTeachingMethod(lessonPlanDTO.getTeachingMethod());
        lessonPlan.setTeachingGoal(lessonPlanDTO.getTeachingGoal());
        lessonPlan.setTeachingKeyPoint(lessonPlanDTO.getTeachingKeyPoint());
        lessonPlan.setTeachingDifficult(lessonPlanDTO.getTeachingDifficult());
        lessonPlan.setIntroduction(lessonPlanDTO.getIntroduction());
        lessonPlan.setExplanation(lessonPlanDTO.getExplanation());
        lessonPlan.setConclusion(lessonPlanDTO.getConclusion());
        lessonPlan.setExpansion(lessonPlanDTO.getExpansion());
        lessonPlan.setCreationMethod(lessonPlanDTO.getCreationMethod());
        lessonPlan.setCreatedAt(String.valueOf(System.currentTimeMillis())); // 设置创建时间
        lessonPlan.setUpdatedAt(String.valueOf(System.currentTimeMillis())); // 设置更新时间
        lessonPlanMapper.addLessonPlan(lessonPlan);
    }

    /**
     * 获取单元下的所有教案
     */
    @Override
    public List<LessonPlan> getLessonPlanListByUnitId(Long unitId) {
        return lessonPlanMapper.getLessonPlanListByUnitId(unitId);
    }

    /**
     * 获取教案详情（按用户 ID）
     */
    @Override
    public LessonPlan getLessonPlanById(Long lessonPlanId) {
        LessonPlan lessonPlan = lessonPlanMapper.getLessonPlanById(lessonPlanId);
        if (lessonPlan == null) {
            throw new LessonPlanNotFoundException("教案未找到，ID=" + lessonPlanId);
        }
        return lessonPlan;
    }

    /**
     * 更新教案信息（按用户 ID）
     */
    @Override
    public void updateLessonPlan(LessonPlanDTO lessonPlanDTO) {
        LessonPlan lessonPlan = getLessonPlanById(lessonPlanDTO.getId());

        lessonPlan.setLessonPlanName(lessonPlanDTO.getLessonPlanName());
        lessonPlan.setUnitId(lessonPlanDTO.getUnitId());
        lessonPlan.setTeachingContent(lessonPlanDTO.getTeachingContent());
        lessonPlan.setTeachingMethod(lessonPlanDTO.getTeachingMethod());
        lessonPlan.setTeachingGoal(lessonPlanDTO.getTeachingGoal());
        lessonPlan.setTeachingKeyPoint(lessonPlanDTO.getTeachingKeyPoint());
        lessonPlan.setTeachingDifficult(lessonPlanDTO.getTeachingDifficult());
        lessonPlan.setIntroduction(lessonPlanDTO.getIntroduction());
        lessonPlan.setExplanation(lessonPlanDTO.getExplanation());
        lessonPlan.setConclusion(lessonPlanDTO.getConclusion());
        lessonPlan.setExpansion(lessonPlanDTO.getExpansion());
        lessonPlan.setCreationMethod(lessonPlanDTO.getCreationMethod());
        lessonPlan.setUpdatedAt(String.valueOf(System.currentTimeMillis())); // 更新时间
        lessonPlanMapper.updateLessonPlan(lessonPlan);
    }

    /**
     * 删除教案（按用户 ID）
     */
    @Override
    public void deleteLessonPlan(List<Long> ids) {
        lessonPlanMapper.deleteLessonPlanByIds(ids);
    }
}
