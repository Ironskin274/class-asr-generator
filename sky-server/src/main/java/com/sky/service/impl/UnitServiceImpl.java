package com.sky.service.impl;

import com.sky.dto.UnitDTO;
import com.sky.entity.Unit;
import com.sky.exception.UnitNotFoundException;
import com.sky.mapper.UnitMapper;
import com.sky.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    /**
     * 创建单元（为特定课程添加）
     */
    @Override
    public void createUnit(UnitDTO unitDTO) {
        Unit unit = new Unit();
        unit.setUnitName(unitDTO.getUnitName());
        unit.setCourseId(unitDTO.getCourseId());
        String currentDateTime = getCurrentDateTimeString();
        unit.setCreatedAt(currentDateTime);
        unit.setUpdatedAt(currentDateTime);
        unitMapper.addUnit(unit);
    }

    /**
     * 查询课程下的所有单元
     */
    @Override
    public List<Unit> getUnitListByCourseId(Long courseId) {
        return unitMapper.getUnitListByCourseId(courseId);
    }

    /**
     * 获取单元详情（按用户 ID）
     */
    @Override
    public Unit getUnitById(Long unitId) {
        Unit unit = unitMapper.getUnitById(unitId);
        if (unit == null) {
            throw new UnitNotFoundException("单元未找到，ID=" + unitId);
        }
        return unit;
    }

    /**
     * 更新单元信息（按用户 ID）
     */
    @Override
    public void updateUnit(UnitDTO unitDTO) {
        Unit unit = getUnitById(unitDTO.getId());

        unit.setUnitName(unitDTO.getUnitName());
        unit.setCourseId(unitDTO.getCourseId());
        unit.setUpdatedAt(getCurrentDateTimeString());

        unitMapper.updateUnit(unit);
    }

    /**
     * 删除单元（按用户 ID）
     */
    @Override
    public void deleteUnit(List<Long> ids) {
        for (Long id : ids) {
            getUnitById(id); // 验证单元是否存在
            unitMapper.deleteUnit(id);
        }
    }

    /**
     * 获取当前时间的字符串表示，格式为 yyyy-MM-dd HH:mm:ss
     * @return 当前时间的字符串表示
     */
    private String getCurrentDateTimeString() {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDateTime localDateTime = Instant.ofEpochMilli(currentTimeMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}