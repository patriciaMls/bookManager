package com.shixun.dao;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:21
 * @version: 1.0
 * @modified By:
 */
public interface DeleteDao {
    public boolean deleteBook(int bookId) throws SQLException;
}
