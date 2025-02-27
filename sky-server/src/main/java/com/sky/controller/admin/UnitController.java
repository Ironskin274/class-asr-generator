package com.sky.controller.admin;

import com.sky.context.BaseContext;
import com.sky.dto.UnitDTO;
import com.sky.entity.Unit;
import com.sky.result.Result;
import com.sky.service.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单元管理
 */
@RestController
@RequestMapping("/unit")
@Slf4j
@Api(tags = "单元相关接口")
public class UnitController {

    @Autowired
    private UnitService unitService;

    /**
     * 查询单元列表
     *
     * @param courseId 课程ID
     * @return 单元列表
     */
    @ApiOperation(value = "查询单元列表")
    @GetMapping("/list/{courseId}")
    public Result<List<Unit>> getUnitList(@PathVariable Long courseId) {
        log.info("查询单元列表：courseId={}", courseId);
        Long userId = BaseContext.getCurrentId();
        List<Unit> units = unitService.getUnitListByCourseId(courseId  );
        return Result.success(units);
    }

    /**
     * 查询单元详情
     *
     * @param id 单元ID
     * @return 单元详情
     */
    @ApiOperation(value = "查询单元详情")
    @GetMapping("/{id}")
    public Result<Unit> getUnitById(@PathVariable Long id) {
        log.info("查询单元详情：id={}", id);
        Long userId = BaseContext.getCurrentId();
        Unit unit = unitService.getUnitById(id  );
        return Result.success(unit);
    }

    /**
     * 新增单元
     *
     * @param unitDTO 单元信息
     * @return 结果
     */
    @ApiOperation(value = "新增单元")
    @PostMapping
    public Result<String> addUnit(@RequestBody UnitDTO unitDTO) {
        log.info("新增单元：{}", unitDTO);
        Long userId = BaseContext.getCurrentId();
        unitService.createUnit(unitDTO  );
        return Result.success("单元添加成功");
    }

    /**
     * 修改单元信息
     *
     * @param unitDTO 单元信息
     * @return 结果
     */
    @ApiOperation(value = "修改单元信息")
    @PutMapping
    public Result<String> updateUnit(@RequestBody UnitDTO unitDTO) {
        log.info("修改单元信息：{}", unitDTO);
        Long userId = BaseContext.getCurrentId();
        unitService.updateUnit(unitDTO  );
        return Result.success("单元信息更新成功");
    }

    /**
     * 删除单元
     *
     * @param ids 单元ID列表
     * @return 结果
     */
    @ApiOperation(value = "删除单元")
    @DeleteMapping
    public Result<String> deleteUnit(@RequestParam List<Long> ids) {
        log.info("删除单元：ids={}", ids);
        Long userId = BaseContext.getCurrentId();
        unitService.deleteUnit(   ids);
        return Result.success("单元删除成功");
    }
}
