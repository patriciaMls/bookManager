package com.shixun.service.impl;

import com.shixun.dao.StudentDao;
import com.shixun.dao.impl.StudentDaoImpl;
import com.shixun.entity.Student;
import com.shixun.service.StudentService;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 15:49
 * @version: 1.0
 * @modified By:
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public boolean register(Student student) throws SQLException {
        return studentDao.register(student);
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        return studentDao.login(username, password);
    }
}
