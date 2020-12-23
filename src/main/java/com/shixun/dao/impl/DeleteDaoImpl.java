package com.shixun.dao.impl;

import com.shixun.dao.DeleteDao;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:22
 * @version: 1.0
 * @modified By:
 */
public class DeleteDaoImpl implements DeleteDao {
    @Override
    public boolean deleteBook(int bookId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "DELETE FROM book WHERE book_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookId);

        int flagTemo = pstmt.executeUpdate();

        if (flagTemo > 0){
            System.out.println("delete successful");
            flag = true;
        }else {
            System.out.println("delete failed");
        }
        return flag;
    }
}
