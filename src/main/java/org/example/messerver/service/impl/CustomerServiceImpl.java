package org.example.messerver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.messerver.entity.Customer;
import org.example.messerver.mapper.CustomerMapper;
import org.example.messerver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 27542
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 根据客户信息查询客户列表
     * @return 客户列表
     */
    @Override
    public List<Customer> queryCustomerList(Customer customer) {
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        // 检查属性是否为 null，避免传递 null 值给 Map.of()
        Map<String, String> fieldMap = Map.of(
                "Id", Objects.toString(customer.getId(), ""),
                "Code", Objects.toString(customer.getCode(), ""),
                "Name", Objects.toString(customer.getName(), ""),
                "Nick", Objects.toString(customer.getNick(), ""),
                "Tel", Objects.toString(customer.getTel(), ""),
                "Type", Objects.toString(customer.getType(), ""),
                "Contact", Objects.toString(customer.getContact(), ""),
                "Contact_Tel", Objects.toString(customer.getContactTel(), "")
        );

        // 使用循环来遍历字段和对应值进行条件判断
        fieldMap.forEach((field, value) -> {
            if (!value.isEmpty()) {  // 仅当值不为空时添加查询条件
                System.out.print(value);
                wrapper.like(field, value);
            }
        });

        return customerMapper.selectList(wrapper);
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public Boolean addCustomer(Customer customer) {
        return customerMapper.insert(customer) > 0;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public Boolean updateCustomer(Customer customer) {
        return customerMapper.updateById(customer) > 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Boolean deleteCustomer(Integer id) {
        return customerMapper.deleteById(id) > 0;
    }
}
