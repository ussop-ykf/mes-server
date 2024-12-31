package org.example.messerver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.messerver.entity.Measurement;
import org.example.messerver.mapper.MeasurementMapper;
import org.example.messerver.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    @Autowired
    MeasurementMapper measurementMapper;

    /**
     * @param measurement
     * @return
     */
    @Override
    public List<Measurement> queryMeasurementList(Measurement measurement) {
        QueryWrapper<Measurement> wrapper = new QueryWrapper<>();
        // 检查属性是否为 null，避免传递 null 值给 Map.of()
        Map<String, String> fieldMap = Map.of("Id", Objects.toString(measurement.getId(), ""), "Code", Objects.toString(measurement.getCode(), ""), "Name", Objects.toString(measurement.getName(), ""), "Flag", Objects.toString(measurement.getFlag(), ""), "Rate", Objects.toString(measurement.getRate(), ""), "Remark", Objects.toString(measurement.getRemark(), ""));

        // 使用循环来遍历字段和对应值进行条件判断
        fieldMap.forEach((field, value) -> {
            if (!value.isEmpty()) {  // 仅当值不为空时添加查询条件
                System.out.print(value);
                wrapper.like(field, value);
            }
        });

        return measurementMapper.selectList(wrapper);
    }

    /**
     * @param measurement
     * @return
     */
    @Override
    public Boolean addMeasurement(Measurement measurement) {
        return measurementMapper.insert(measurement) > 0;
    }

    /**
     * @param measurement
     * @return
     */
    @Override
    public Boolean updateMeasurement(Measurement measurement) {
        return measurementMapper.updateById(measurement) > 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Boolean deleteMeasurement(Integer id) {
        return measurementMapper.deleteById(id) > 0;
    }
}
