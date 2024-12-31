package org.example.messerver.controller;

import org.example.messerver.entity.Measurement;
import org.example.messerver.entity.Vendor;
import org.example.messerver.service.MeasurementService;
import org.example.messerver.service.VendorService;
import org.example.messerver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 27542
 */
@RestController
@RequestMapping("/mes/vendor")
public class VendorController {
    @Autowired
    VendorService vendorService;

    @RequestMapping("list")
    public Result queryCustomerList(Vendor vendor) {
        return Result.success("查询成功", vendorService.queryVendorList(vendor));
    }

    @RequestMapping("add")
    public Result addVendor(Vendor vendor) {
        if (vendorService.addVendor(vendor)) {
            return Result.error("添加成功");
        }
        return Result.error("添加失败");
    }
    @RequestMapping("update")
    public Result updateVendorInfo(Vendor vendor) {

        if (vendorService.updateVendor(vendor)) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @RequestMapping("del")
    public Result delVendor(Integer id) {
        if (vendorService.deleteVendor(id)) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
