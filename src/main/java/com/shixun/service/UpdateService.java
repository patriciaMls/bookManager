package com.shixun.service;

import com.shixun.entity.Book;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 12:02
 * @version: 1.0
 * @modified By:
 */
public interface UpdateService {
    public boolean updateBook(Book book) throws SQLException;
}
