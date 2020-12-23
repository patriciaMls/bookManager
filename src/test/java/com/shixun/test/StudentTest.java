package com.shixun.test;

import com.shixun.entity.Student;
import com.shixun.utils.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        conn= DruidUtil.getInstance().getConnection();
        sql = "SELECT stu_id, stu_num, stu_name, stu_class, stu_username, stu_password FROM student WHERE stu_username = ? AND stu_password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int stuId = rs.getInt("stu_id");
            String stuNum = rs.getString("stu_num");
            String stuName = rs.getString("stu_name");
            String stuClass = rs.getString("stu_class");
            String stuUsername = rs.getString("stu_username");
            String stuPassword = rs.getString("stu_password");
            Student student = new Student(stuId, stuNum, stuName, stuClass, stuUsername, stuPassword);
            list.add(student);
            System.out.println(student);
            System.out.println("login successful");
        }
        System.out.println(list);
        DruidUtil.getInstance().closeConnection(conn);
    }
}
