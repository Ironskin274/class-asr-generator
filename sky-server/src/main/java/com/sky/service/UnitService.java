package com.sky.service;

import com.sky.entity.Unit;
import com.sky.dto.UnitDTO;

import java.util.List;

public interface UnitService {

    // 创建单元
    void createUnit(UnitDTO unitDTO);

    // 获取课程下的所有单元
    List<Unit> getUnitListByCourseId(Long courseId);

    // 获取单元详情
    Unit getUnitById(Long unitId);

    // 更新单元
    void updateUnit(UnitDTO unitDTO);

    // 删除单元
    void deleteUnit(List<Long> ids);
}
