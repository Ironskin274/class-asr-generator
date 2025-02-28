package com.sky.service.impl;

import com.sky.dto.LessonPlanDTO;
import com.sky.entity.LessonPlan;
import com.sky.exception.LessonPlanNotFoundException;
import com.sky.mapper.LessonPlanMapper;
import com.sky.service.LessonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LessonPlanServiceImpl implements LessonPlanService {

    @Autowired
    private LessonPlanMapper lessonPlanMapper;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
        String currentDateTime = getCurrentDateTimeString();
        lessonPlan.setCreatedAt(currentDateTime); // 设置创建时间
        lessonPlan.setUpdatedAt(currentDateTime); // 设置更新时间
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
        lessonPlan.setUpdatedAt(getCurrentDateTimeString()); // 更新时间
        lessonPlanMapper.updateLessonPlan(lessonPlan);
    }

    /**
     * 删除教案（按用户 ID）
     */
    @Override
    public void deleteLessonPlan(List<Long> ids) {
        lessonPlanMapper.deleteLessonPlanByIds(ids);
    }

    /**
     * 获取当前时间的字符串表示，格式为 yyyy-MM-dd HH:mm:ss
     * @return 当前时间的字符串表示
     */
    private String getCurrentDateTimeString() {
        LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return localDateTime.format(DATE_TIME_FORMATTER);
    }
}