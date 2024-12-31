package org.example.messerver.service;

import org.example.messerver.entity.Admin;

/**
 * @author 27542
 */
public interface AdminService {
    Admin queryById(String username);
}
