package com.sky.service;

import com.sky.dto.CourseDTO;
import com.sky.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseList(Long userId, int page, int size);

    Course getCourseById(Long userId, Long courseId);

    void addCourse(CourseDTO courseDTO, Long userId);

    void updateCourse(CourseDTO courseDTO, Long userId);

    void deleteCourse(Long userId, List<Long> ids);

    void changeCourseStatus(Long userId, List<Long> ids, String status);
}
