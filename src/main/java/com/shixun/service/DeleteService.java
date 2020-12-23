package com.shixun.service;

import java.sql.SQLException;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 11:27
 * @version: 1.0
 * @modified By:
 */
public interface DeleteService {
    public boolean deleteBook(int bookId) throws SQLException;
}
