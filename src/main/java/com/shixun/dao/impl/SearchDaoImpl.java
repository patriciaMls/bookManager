package com.shixun.dao.impl;

import com.shixun.dao.SearchDao;
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
 * @date: Created in 2020/12/23 10:09
 * @version: 1.0
 * @modified By:
 */
public class SearchDaoImpl implements SearchDao {
    @Override
    public List<Book> searchBook(String title) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        List<Book> bookList = new ArrayList<>();

        conn = DruidUtil.getInstance().getConnection();
        sql = "SELECT * FROM book WHERE book.book_title LIKE concat('%', ?, '%')";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String bookTitle = rs.getString("book_title");
            String bookNum = rs.getString("book_num");
            String bookAuthor = rs.getString("book_author");
            Book book = new Book(bookId,bookTitle,bookNum,bookAuthor);
            bookList.add(book);
        }

        DruidUtil.getInstance().closeConnection(conn);
        return bookList;
    }
}
