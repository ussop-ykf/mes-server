package org.example.messerver.controller;

import org.example.messerver.entity.Admin;
import org.example.messerver.service.AdminService;
import org.example.messerver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mes/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    public Result checkAdmin(String username, String password) {
        Admin admin = adminService.queryById(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return Result.success("登录成功", admin);
        }
        return Result.error("登录失败");
    }
}
