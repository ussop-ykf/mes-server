package org.example.messerver.service.impl;

import org.example.messerver.entity.Admin;
import org.example.messerver.mapper.AdminMapper;
import org.example.messerver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    /**
     * @param username
     * @return
     */
    @Override
    public Admin queryById(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Username", username);
        return !adminMapper.selectByMap(map).isEmpty() ? adminMapper.selectByMap(map).get(0) : null;
    }
}
