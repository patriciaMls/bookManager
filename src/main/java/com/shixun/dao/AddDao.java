package com.shixun.dao;

import com.shixun.entity.Book;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 10:47
 * @version: 1.0
 * @modified By:
 */
public interface AddDao {
    public boolean addBook(Book book) throws SQLException;
}
