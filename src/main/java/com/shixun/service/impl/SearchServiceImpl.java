package com.shixun.service.impl;

import com.shixun.dao.SearchDao;
import com.shixun.dao.impl.SearchDaoImpl;
import com.shixun.entity.Book;
import com.shixun.service.SearchService;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 10:36
 * @version: 1.0
 * @modified By:
 */
public class SearchServiceImpl implements SearchService {
    private SearchDao searchDao = new SearchDaoImpl();
    @Override
    public List<Book> searchBook(String title) throws SQLException {
        return searchDao.searchBook(title);
    }
}
