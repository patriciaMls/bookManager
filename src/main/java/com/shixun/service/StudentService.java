package com.shixun.service;

import com.shixun.entity.Student;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 15:48
 * @version: 1.0
 * @modified By:
 */
public interface StudentService {
    public boolean register(Student student) throws SQLException;

    public boolean login(String username, String password) throws SQLException;
}
