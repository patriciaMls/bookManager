package com.shixun.service.impl;

import com.shixun.dao.UpdateDao;
import com.shixun.dao.impl.UpdateDaoImpl;
import com.shixun.entity.Book;
import com.shixun.service.UpdateService;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 12:04
 * @version: 1.0
 * @modified By:
 */
public class UpdateServiceImpl implements UpdateService {
    private UpdateDao updateDao = new UpdateDaoImpl();
    @Override
    public boolean updateBook(Book book) throws SQLException {
        return updateDao.updateBook(book);
    }
}
