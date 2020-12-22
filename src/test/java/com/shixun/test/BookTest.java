package com.shixun.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:42
 * @version: 1.0
 * @modified By:
 */
public class BookTest {
    @Test
    public void getBookList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        List<Book> bookList = new ArrayList<>();

        conn = DruidUtil.getInstance().getConnection();
        sql = "SELECT * FROM shixun.book";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String bookTitle = rs.getString("book_title");
            String bookNum = rs.getString("book_num");
            String bookAuthor = rs.getString("book_author");
            Book book = new Book(bookId,bookTitle,bookNum,bookAuthor);
            bookList.add(book);
            System.out.println(book);
        }

        for (Book book : bookList) {
            System.out.println("toString: "+book.toString());
        }

        DruidUtil.getInstance().closeConnection(conn);
    }

    @Test
    public void method1() throws Exception {
        Properties pro = new Properties(); // 读取配置文件的一个集合
        InputStream is = BookTest.class.getClassLoader().getResourceAsStream("druid.properties");
        //反射
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        DatabaseMetaData dmd = conn.getMetaData();
        String dbName = dmd.getDatabaseProductName();       // 数据库名
        String dbVersion = dmd.getDatabaseProductVersion(); // 数据库版本
        System.out.println(dbName + " : " + dbVersion);
    }

    @Test
    public void method2() throws SQLException {
        Connection connection = DruidUtil.getInstance().getConnection();
        DatabaseMetaData dmd = connection.getMetaData();
        String dbName = dmd.getDatabaseProductName();
        String dbVersion = dmd.getDriverVersion();
        System.out.println(dbName + " : " + dbVersion);
        DruidUtil.getInstance().closeConnection(connection);
    }
}
