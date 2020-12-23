package com.shixun.dao.impl;

import com.shixun.dao.AddDao;
import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 10:48
 * @version: 1.0
 * @modified By:
 */
public class AddDaoImpl implements AddDao {
    @Override
    public boolean addBook(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "INSERT INTO book(book_title, book_num, book_author) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookTitle());
        pstmt.setString(2, book.getBookNum());
        pstmt.setString(3, book.getBookAuthor());

        int flagTemp = pstmt.executeUpdate();
        if (flagTemp > 0){
            flag = true;
            System.out.println("insert successful");
        }else {
            System.out.println("insert failed");
        }

        return flag;
    }
}
