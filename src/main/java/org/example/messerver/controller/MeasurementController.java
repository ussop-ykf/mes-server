package org.example.messerver.controller;


import org.example.messerver.entity.Measurement;
import org.example.messerver.service.MeasurementService;
import org.example.messerver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 27542
 */
@RestController
@RequestMapping("/mes/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    @RequestMapping("list")
    public Result queryCustomerList(Measurement measurement) {
        return Result.success("查询成功", measurementService.queryMeasurementList(measurement));
    }

    @RequestMapping("add")
    public Result addMeasurement(Measurement measurement) {
        if (measurementService.addMeasurement(measurement)) {
            return Result.error("添加成功");
        }
        return Result.error("添加失败");
    }
    @RequestMapping("update")
    public Result updateMeasurementInfo(Measurement measurement) {

        if (measurementService.updateMeasurement(measurement)) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @RequestMapping("del")
    public Result delMeasurement(Integer id) {
        if (measurementService.deleteMeasurement(id)) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
