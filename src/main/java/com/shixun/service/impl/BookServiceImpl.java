package com.shixun.service.impl;

import com.shixun.dao.BookDao;
import com.shixun.dao.impl.BookDaoImpl;
import com.shixun.entity.Book;
import com.shixun.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:25
 * @version: 1.0
 * @modified By:
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBookList() throws SQLException {
        return bookDao.getBookList();
    }

    @Override
    public boolean addBook(Book book) throws SQLException {
        return bookDao.addBook(book);
    }

    @Override
    public boolean deleteBook(int bookId) throws SQLException {
        return bookDao.deleteBook(bookId);
    }

    @Override
    public List<Book> searchBook(String title) throws SQLException {
        return bookDao.searchBook(title);
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        return bookDao.updateBook(book);
    }
}
