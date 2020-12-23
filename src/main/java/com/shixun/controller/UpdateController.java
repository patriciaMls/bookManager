package com.shixun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shixun.entity.Book;
import com.shixun.service.BookService;
import com.shixun.service.impl.BookServiceImpl;

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
 * @description:修改书籍信息的控制类
 * @author: Patricia
 * @date: Created in 2020/12/23 12:06
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

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
            flag = bookService.updateBook(book);
        } catch (SQLException e) {
            System.out.println("UpdateController SQLException");
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", flag);

        System.out.println(map);
//        response.setHeader("Access-Control-Allow-Origin", "http://192.168.43.37:8080");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
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
