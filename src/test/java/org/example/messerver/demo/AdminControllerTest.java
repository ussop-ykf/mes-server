package org.example.messerver.demo;

import org.example.messerver.controller.AdminController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminControllerTest {
    @Autowired
    AdminController adminController;
    @Test
    public void testCheckAdmin() {
        System.out.println(adminController.checkAdmin("admin", "123456"));
    }
}
