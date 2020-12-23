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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:验证用户登录的控制类
 * @author: Patricia
 * @date: Created in 2020/12/23 16:06
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("-------LoginController-------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<Student> list = new ArrayList<>();

        try {
            list = studentService.login(username, password);
            System.out.println(list);
        } catch (SQLException e) {
            System.out.println("LoginController SQLException");
            e.printStackTrace();
        }

        //response.setHeader("Access-Control-Allow-Origin", "http://192.168.43.37:8080");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        if (list.isEmpty()){
            map.put("code", 400);
            map.put("msg", "failed");
            map.put("data", false);
        }else {
            map.put("code", 200);
            map.put("msg", "success");
            map.put("data", list);
        }

        System.out.println(map);
        String s = objectMapper.writeValueAsString(map);
        PrintWriter out = response.getWriter();
        out.println(s);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
