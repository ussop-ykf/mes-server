package org.example.messerver.demo;

import org.example.messerver.controller.CustomerController;
import org.example.messerver.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @Autowired
    CustomerController customerController;
    @Test
    public void testList() {
        Customer customer = new Customer();
//        customer.setId(1);
        System.out.println(customerController.queryCustomerList(customer));
    }

    @Test
    public void testAdd() {
        Customer customer = new Customer();
        customer.setName("anc");
        customer.setCode("123");
        customer.setContact("bcd");

        customerController.addCustomer(customer);
    }
    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("anc");
        customer.setCode("123");
        customer.setContact("bcd");

        customerController.updateCustomerInfo(customer);
    }
    @Test
    public void testDel() {
        customerController.delCustomer(7);
    }
}
