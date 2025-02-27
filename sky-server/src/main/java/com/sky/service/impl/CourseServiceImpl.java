package com.sky.service.impl;

import com.sky.dto.CourseDTO;
import com.sky.entity.Course;
import com.sky.exception.CourseNotFoundException;
import com.sky.mapper.CourseMapper;
import com.sky.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程列表（分页，按用户 ID）
     */
    @Override
    public List<Course> getCourseList(Long userId, int page, int size) {
        int offset = (page - 1) * size;
        return courseMapper.getCourseListByUser(userId, offset, size);
    }

    /**
     * 查询单个课程详情（按用户 ID）
     */
    @Override
    public Course getCourseById(Long userId, Long courseId) {
        Course course = courseMapper.getCourseById(courseId, userId);
        if (course == null) {
            throw new CourseNotFoundException("课程未找到，ID=" + courseId);
        }
        return course;
    }

    /**
     * 新增课程（为特定用户添加）
     */
    @Override
    public void addCourse(CourseDTO courseDTO, Long userId) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseTarget(courseDTO.getCourseTarget());
        course.setCourseType(courseDTO.getCourseType());
        course.setCreditHours(courseDTO.getCreditHours());
        course.setCredits(courseDTO.getCredits());
        course.setUserId(userId);

        courseMapper.addCourse(course);
    }

    /**
     * 修改课程信息（按用户 ID）
     */
    @Override
    public void updateCourse(CourseDTO courseDTO, Long userId) {
        Course course = getCourseById(userId, courseDTO.getId());

        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseTarget(courseDTO.getCourseTarget());
        course.setCourseType(courseDTO.getCourseType());
        course.setCreditHours(courseDTO.getCreditHours());
        course.setCredits(courseDTO.getCredits());

        courseMapper.updateCourse(course);
    }

    /**
     * 删除课程（按用户 ID）
     */
    @Override
    public void deleteCourse(Long userId, List<Long> ids) {
        for (Long id : ids) {
            getCourseById(userId, id); // 验证课程是否存在
            courseMapper.deleteCourse(id, userId);
        }
    }

    /**
     * 批量修改课程状态（按用户 ID）
     */
    @Override
    public void changeCourseStatus(Long userId, List<Long> ids, String status) {
        courseMapper.changeCourseStatus(ids, status, userId);
    }
}