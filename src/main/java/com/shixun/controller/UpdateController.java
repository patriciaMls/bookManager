package com.shixun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shixun.entity.Book;
import com.shixun.service.UpdateService;
import com.shixun.service.impl.UpdateServiceImpl;

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
 * @date: Created in 2020/12/23 12:06
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private UpdateService updateService = new UpdateServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("-------UpdateController-------");
        String bookId = request.getParameter("bookId");
        String bookTitle = request.getParameter("bookTitle");
        String bookNum = request.getParameter("bookNum");
        String bookAuthor = request.getParameter("bookAuthor");
        boolean flag = false;

        int id = Integer.parseInt(bookId);
        Book book = new Book(id, bookTitle, bookNum, bookAuthor);

        try {
            flag = updateService.updateBook(book);
        } catch (SQLException e) {
            System.out.println("UpdateController SQLException");
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", flag);

        System.out.println(map);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        PrintWriter out = response.getWriter();
        out.println(s);
        out.close();
    }
}
