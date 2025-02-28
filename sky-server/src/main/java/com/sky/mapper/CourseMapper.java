package com.sky.mapper;

import com.sky.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CourseMapper {


    /**
     * 获取所有课程
     *
     * @param userId 用户ID
     * @return 所有课程列表
     */
    List<Course> getAllCourses(Long userId);

    /**
     * 查询指定用户的课程列表（分页）
     *
     * @param userId 用户ID
     * @param offset 分页偏移量
     * @param size   每页数量
     * @return 课程列表
     */
    List<Course> getCourseListByUser(@Param("userId") Long userId,
                                     @Param("offset") int offset,
                                     @Param("size") int size);

    /**
     * 根据课程ID查询课程（按用户ID验证）
     *
     * @param courseId 课程ID
     * @param userId   用户ID
     * @return 课程详情
     */
    Course getCourseById(@Param("courseId") Long courseId,
                         @Param("userId") Long userId);

    /**
     * 新增课程（为特定用户添加课程）
     *
     * @param course 课程实体
     */
    void addCourse(Course course);

    /**
     * 更新课程信息（按用户ID进行检查）
     *
     * @param course 课程实体
     */
    void updateCourse(Course course);

    /**
     * 删除课程（按用户ID进行检查）
     *
     * @param courseId 课程ID
     * @param userId   用户ID
     */
    void deleteCourse(@Param("courseId") Long courseId,
                      @Param("userId") Long userId);

    /**
     * 批量修改课程状态（启用/禁用，按用户ID）
     *
     * @param ids    课程ID列表
     * @param status 状态（启用/禁用）
     * @param userId 用户ID
     */
    void changeCourseStatus(@Param("ids") List<Long> ids,
                            @Param("status") String status,
                            @Param("userId") Long userId);
}
