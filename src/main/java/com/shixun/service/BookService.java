package com.shixun.service;

import com.shixun.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:22
 * @version: 1.0
 * @modified By:
 */
public interface BookService {
    public List<Book> getBookList() throws SQLException;

    public boolean addBook(Book book) throws SQLException;

    public boolean deleteBook(int bookId) throws SQLException;

    public List<Book> searchBook(String title) throws SQLException;

    public boolean updateBook(Book book) throws SQLException;

}
