package org.example.messerver.controller;

import org.example.messerver.entity.Customer;
import org.example.messerver.service.CustomerService;
import org.example.messerver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 27542
 */
@RestController
@RequestMapping("/mes/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("list")
    public Result queryCustomerList(Customer customer) {
        return Result.success("查询成功", customerService.queryCustomerList(customer));
    }

    @RequestMapping("add")
    public Result addCustomer(Customer customer) {
        if (customerService.addCustomer(customer)) {
            return Result.error("添加成功");
        }
        return Result.error("添加失败");
    }
    @RequestMapping("update")
    public Result updateCustomerInfo(Customer customer) {

        if (customerService.updateCustomer(customer)) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @RequestMapping("del")
    public Result delCustomer(Integer id) {
        if (customerService.deleteCustomer(id)) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
