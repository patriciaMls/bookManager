package com.shixun.service.impl;

import com.shixun.dao.AddDao;
import com.shixun.dao.impl.AddDaoImpl;
import com.shixun.entity.Book;
import com.shixun.service.AddService;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:04
 * @version: 1.0
 * @modified By:
 */
public class AddServiceImpl implements AddService {
    private AddDao addDao = new AddDaoImpl();
    @Override
    public boolean addBook(Book book) throws SQLException {
        return addDao.addBook(book);
    }
}
