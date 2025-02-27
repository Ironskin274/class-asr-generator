package com.sky.controller.admin;

import com.sky.dto.CourseDTO;
import com.sky.entity.Course;
import com.sky.result.Result;
import com.sky.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程管理
 */
@RestController
@RequestMapping("/admin/course")
@Slf4j
@Api(tags = "课程相关接口")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询课程列表
     *
     * @param page 页码
     * @param size 每页数量
     * @return 课程列表
     */
    @ApiOperation(value = "查询课程列表")
    @GetMapping("/list")
    public Result<List<Course>> getCourseList(@RequestParam int page, @RequestParam int size) {
        log.info("查询课程列表：page={}, size={}", page, size);
        List<Course> courses = courseService.getCourseList(page, size);
        return Result.success(courses);
    }

    /**
     * 查询课程详情
     *
     * @param id 课程ID
     * @return 课程详情
     */
    @ApiOperation(value = "查询课程详情")
    @GetMapping("/{id}")
    public Result<Course> getCourseById(@PathVariable Long id) {
        log.info("查询课程详情：id={}", id);
        Course course = courseService.getCourseById(id);
        return Result.success(course);
    }

    /**
     * 新增课程
     *
     * @param courseDTO 课程信息
     * @return 结果
     */
    @ApiOperation(value = "新增课程")
    @PostMapping
    public Result<String> addCourse(@RequestBody CourseDTO courseDTO) {
        System.out.println("123");
        log.info("新增课程：{}", courseDTO);
        courseService.addCourse(courseDTO);
        return Result.success("课程添加成功");
    }

    /**
     * 修改课程信息
     *
     * @param courseDTO 课程信息
     * @return 结果
     */
    @ApiOperation(value = "修改课程信息")
    @PutMapping
    public Result<String> updateCourse(@RequestBody CourseDTO courseDTO) {
        log.info("修改课程信息：{}", courseDTO);
        courseService.updateCourse(courseDTO);
        return Result.success("课程信息更新成功");
    }

    /**
     * 删除课程
     *
     * @param ids 课程ID列表
     * @return 结果
     */
    @ApiOperation(value = "删除课程")
    @DeleteMapping
    public Result<String> deleteCourse(@RequestParam List<Long> ids) {
        log.info("删除课程：ids={}", ids);
        courseService.deleteCourse(ids);
        return Result.success("课程删除成功");
    }

    /**
     * 批量修改课程状态（例如启用/禁用）
     *
     * @param ids    课程ID列表
     * @param status 状态（启用/禁用）
     * @return 结果
     */
    @ApiOperation(value = "批量修改课程状态")
    @PostMapping("/status")
    public Result<String> changeCourseStatus(@RequestParam List<Long> ids, @RequestParam String status) {
        log.info("批量修改课程状态：ids={}, status={}", ids, status);
        courseService.changeCourseStatus(ids, status);
        return Result.success("课程状态修改成功");
    }

}
