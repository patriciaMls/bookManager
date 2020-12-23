package com.shixun.service.impl;

import com.shixun.dao.DeleteDao;
import com.shixun.dao.impl.DeleteDaoImpl;
import com.shixun.service.DeleteService;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:28
 * @version: 1.0
 * @modified By:
 */
public class DeleteServiceImpl implements DeleteService {
    DeleteDao deleteDao = new DeleteDaoImpl();
    @Override
    public boolean deleteBook(int bookId) throws SQLException {
        return deleteDao.deleteBook(bookId);
    }
}
