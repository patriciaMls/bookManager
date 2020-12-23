package com.shixun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shixun.entity.Book;
import com.shixun.service.AddService;
import com.shixun.service.impl.AddServiceImpl;

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
 * @date: Created in 2020/12/23 11:05
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/add")
public class AddController extends HttpServlet {
    private AddService addService = new AddServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("-------SearchController-------");
        String bookTitle = request.getParameter("bookTitle");
        String bookNum = request.getParameter("bookNum");
        String bookAuthor = request.getParameter("bookAuthor");
        boolean flag = false;

        Book book = new Book();
        book.setBookTitle(bookTitle);
        book.setBookNum(bookNum);
        book.setBookAuthor(bookAuthor);

        try {
            flag = addService.addBook(book);
        } catch (SQLException e) {
            System.out.println("AddController SQLException");
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("flag", flag);

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
