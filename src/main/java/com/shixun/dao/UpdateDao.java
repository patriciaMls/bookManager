package com.shixun.dao;

import com.shixun.entity.Book;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:41
 * @version: 1.0
 * @modified By:
 */
public interface UpdateDao {
    public boolean updateBook(Book book) throws SQLException;
}
