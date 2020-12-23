package com.shixun.dao.impl;

import com.shixun.dao.UpdateDao;
import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:50
 * @version: 1.0
 * @modified By:
 */
public class UpdateDaoImpl implements UpdateDao {
    @Override
    public boolean updateBook(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "UPDATE `shixun`.`book` SET `book_title` = ?, `book_num` = ?, `book_author` = ? WHERE `book_id` = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookTitle());
        pstmt.setString(2, book.getBookNum());
        pstmt.setString(3, book.getBookAuthor());
        pstmt.setInt(4, book.getBookId());

        int flagTemp = pstmt.executeUpdate();
        if (flagTemp > 0){
            System.out.println("update successful");
            flag = true;
        }else {
            System.out.println("update failed");
        }

        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }
}
