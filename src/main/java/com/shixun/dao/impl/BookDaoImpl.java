package com.shixun.dao.impl;

import com.shixun.dao.BookDao;
import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:03
 * @version: 1.0
 * @modified By:
 */
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBookList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        List<Book> bookList = new ArrayList<>();

        conn = DruidUtil.getInstance().getConnection();
        sql = "SELECT * FROM book";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String bookTitle = rs.getString("book_title");
            String bookNum = rs.getString("book_num");
            String bookAuthor = rs.getString("book_author");
            Book book = new Book(bookId,bookTitle,bookNum,bookAuthor);
            bookList.add(book);
        }

        return bookList;
    }
}
