package com.shixun.dao.impl;

import com.shixun.dao.StudentDao;
import com.shixun.entity.Student;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:对学生表的操作（注册及登录）
 * @author: Patricia
 * @date: Created in 2020/12/23 15:42
 * @version: 1.0
 * @modified By:
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean register(Student student) throws SQLException {
        /**
         * @descript :实现注册新的学生用户
         * @author :Patricia
         * @date :2020/12/23 17:27
         * @param :[student]
         * @return :boolean
         * @throws :
         * @since :
         */

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn= DruidUtil.getInstance().getConnection();
        sql = "INSERT INTO `student` (`stu_num`, `stu_name`, `stu_class`, `stu_username`, `stu_password`) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getStuNum());
        pstmt.setString(2, student.getStuName());
        pstmt.setString(3,student.getStuClass());
        pstmt.setString(4,student.getStuUsername());
        pstmt.setString(5,student.getStuPassword());
        int flagTemp = pstmt.executeUpdate();
        if (flagTemp>0){
            System.out.println("Register success!");
            flag = true;
        }else {
            System.out.println("Register failed!");
        }
        System.out.println(flag);
        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        /**
         * @descript :验证学生用户的登录
         * @author :Patricia
         * @date :2020/12/23 17:28
         * @param :[username, password]
         * @return :boolean
         * @throws :
         * @since :
         */

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs = null;
        boolean flag = false;

        conn= DruidUtil.getInstance().getConnection();
        sql = "SELECT student.stu_username,student.stu_password FROM student WHERE stu_username = ? AND stu_password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        if (rs.next()){
            flag = true;
            System.out.println("login successful");
        }else {
            System.out.println("username or password error!");
            System.out.println("login failed");
        }
        System.out.println(flag);
        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }
}
