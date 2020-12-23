package com.shixun.service;

import com.shixun.entity.Book;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:03
 * @version: 1.0
 * @modified By:
 */
public interface AddService {
    public boolean addBook(Book book) throws SQLException;
}
