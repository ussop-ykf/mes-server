package org.example.messerver.service;

import org.example.messerver.entity.Customer;

import java.util.List;

/**
 * @author 27542
 */
public interface CustomerService {
    List<Customer> queryCustomerList(Customer customer);
    Boolean addCustomer(Customer customer);
    Boolean updateCustomer(Customer customer);
    Boolean deleteCustomer(Integer id);
}
