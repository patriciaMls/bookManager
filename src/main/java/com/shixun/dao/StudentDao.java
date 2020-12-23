package com.shixun.dao;

import com.shixun.entity.Student;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 15:41
 * @version: 1.0
 * @modified By:
 */
public interface StudentDao {
    public boolean register(Student student) throws SQLException;

    public boolean login(String username, String password) throws SQLException;
}
