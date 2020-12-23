package com.shixun.test;

import com.shixun.entity.Student;
import com.shixun.utils.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 15:44
 * @version: 1.0
 * @modified By:
 */
public class StudentTest {
    @Test
    public void register() throws SQLException {
        Student student = new Student();
        student.setStuNum("201901238");
        student.setStuName("Eve");
        student.setStuClass("PE201901");
        student.setStuUsername("eve@qq.com");
        student.setStuPassword("123458");


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
    }

    @Test
    public void login() throws SQLException {
        String username = "ace@qq.com";
        String password = "123421";

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
    }
}
