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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:30
 * @version: 1.0
 * @modified By:
 */
@WebServlet("/bookList")
public class BookListController extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("-------BookListController-------");
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookService.getBookList();
        } catch (SQLException e) {
            System.out.println("BookListController SQLException");
            e.printStackTrace();
            return;
        }

        if (bookList == null){
            System.out.println("videoList is null, please check it");
            return;
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", bookList);

        System.out.println(map);
        for (Book book : bookList) {
            System.out.println("toString: "+book.toString());
        }

        String s = objectMapper.writeValueAsString(map);
        PrintWriter out = response.getWriter();
        out.println(s);
        out.close();
    }
}
