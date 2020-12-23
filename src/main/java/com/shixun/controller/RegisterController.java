package com.shixun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shixun.entity.Student;
import com.shixun.service.StudentService;
import com.shixun.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 15:50
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("-------RegisterController-------");
        String stuNum = request.getParameter("stuNum");
        String stuName = request.getParameter("stuName");
        String stuClass = request.getParameter("stuClass");
        String stuUsername = request.getParameter("stuUsername");
        String stuPassword = request.getParameter("stuPassword");
        boolean flag = false;

        Student student = new Student();
        student.setStuName(stuName);
        student.setStuNum(stuNum);
        student.setStuClass(stuClass);
        student.setStuUsername(stuUsername);
        student.setStuPassword(stuPassword);

        try {
            flag = studentService.register(student);
        } catch (SQLException e) {
            System.out.println("RegisterController SQLException");
            e.printStackTrace();
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", flag);

        System.out.println(map);
        String s = objectMapper.writeValueAsString(map);
        PrintWriter out = response.getWriter();
        out.println(s);
        out.close();
    }
}
