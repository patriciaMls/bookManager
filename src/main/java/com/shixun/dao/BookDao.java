package com.shixun.dao;

import com.shixun.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 18:58
 * @version: 1.0
 * @modified By:
 */
public interface BookDao {
    public List<Book> getBookList() throws SQLException;
}
