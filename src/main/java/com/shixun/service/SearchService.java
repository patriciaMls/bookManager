package com.shixun.service;

import com.shixun.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 10:35
 * @version: 1.0
 * @modified By:
 */
public interface SearchService {
    public List<Book> searchBook(String title) throws SQLException;
}
