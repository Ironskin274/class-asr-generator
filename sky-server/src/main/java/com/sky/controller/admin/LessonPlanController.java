package com.sky.controller.admin;

import com.sky.context.BaseContext;
import com.sky.dto.LessonPlanDTO;
import com.sky.entity.LessonPlan;
import com.sky.result.Result;
import com.sky.service.LessonPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教案管理
 */
@RestController
@RequestMapping("/plan")
@Slf4j
@Api(tags = "教案相关接口")
public class LessonPlanController {

    @Autowired
    private LessonPlanService lessonPlanService;

    /**
     * 查询教案列表
     *
     * @param unitId 单元ID
     * @return 教案列表
     */
    @ApiOperation(value = "查询教案列表")
    @GetMapping("/list/{unitId}")
    public Result<List<LessonPlan>> getLessonPlanList(@PathVariable Long unitId) {
        log.info("查询教案列表：unitId={}", unitId);
        Long userId = BaseContext.getCurrentId();
        List<LessonPlan> lessonPlans = lessonPlanService.getLessonPlanListByUnitId(unitId);
        return Result.success(lessonPlans);
    }

    /**
     * 查询教案详情
     *
     * @param id 教案ID
     * @return 教案详情
     */
    @ApiOperation(value = "查询教案详情")
    @GetMapping("/{id}")
    public Result<LessonPlan> getLessonPlanById(@PathVariable Long id) {
        log.info("查询教案详情：id={}", id);
        Long userId = BaseContext.getCurrentId();
        LessonPlan lessonPlan = lessonPlanService.getLessonPlanById(id );
        return Result.success(lessonPlan);
    }

    /**
     * 新增教案
     *
     * @param lessonPlanDTO 教案信息
     * @return 结果
     */
    @ApiOperation(value = "新增教案")
    @PostMapping
    public Result<String> addLessonPlan(@RequestBody LessonPlanDTO lessonPlanDTO) {
        log.info("新增教案：{}", lessonPlanDTO);
        lessonPlanService.createLessonPlan(lessonPlanDTO );
        return Result.success("教案添加成功");
    }

    /**
     * 修改教案信息
     *
     * @param lessonPlanDTO 教案信息
     * @return 结果
     */
    @ApiOperation(value = "修改教案信息")
    @PutMapping
    public Result<String> updateLessonPlan(@RequestBody LessonPlanDTO lessonPlanDTO) {
        log.info("修改教案信息：{}", lessonPlanDTO);
        lessonPlanService.updateLessonPlan(lessonPlanDTO );
        return Result.success("教案信息更新成功");
    }

    /**
     * 删除教案
     *
     * @param ids 教案ID列表
     * @return 结果
     */
    @ApiOperation(value = "删除教案")
    @DeleteMapping
    public Result<String> deleteLessonPlan(@RequestParam List<Long> ids) {
        log.info("删除教案：ids={}", ids);
        Long userId = BaseContext.getCurrentId();
        lessonPlanService.deleteLessonPlan(ids);
        return Result.success("教案删除成功");
    }
}
