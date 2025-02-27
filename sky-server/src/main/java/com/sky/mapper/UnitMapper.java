package com.sky.mapper;

import com.sky.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UnitMapper {

    // 添加单元
    void addUnit(Unit unit);

    // 根据课程ID查询单元列表
    List<Unit> getUnitListByCourseId(@Param("courseId") Long courseId);

    // 根据单元ID查询单元详情
    Unit getUnitById(@Param("unitId") Long unitId);

    // 更新单元信息
    void updateUnit(Unit unit);

    // 删除单元
    void deleteUnit(@Param("unitId") Long unitId);

    // 查询某单元是否关联教案
    int countByUnitId(@Param("unitId") Long unitId);
}
