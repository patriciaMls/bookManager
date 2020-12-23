package com.shixun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shixun.service.DeleteService;
import com.shixun.service.impl.DeleteServiceImpl;

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
 * @date: Created in 2020/12/23 11:31
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    DeleteService deleteService = new DeleteServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookId = request.getParameter("bookId");
        boolean flag = false;

        int id = Integer.parseInt(bookId);
        try {
            flag = deleteService.deleteBook(id);
        } catch (SQLException e) {
            System.out.println("DeleteController SQLException");
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("flag", flag);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        PrintWriter out = response.getWriter();
        out.println(s);
        out.close();

    }
}
