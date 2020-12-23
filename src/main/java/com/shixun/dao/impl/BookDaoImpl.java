package com.shixun.dao.impl;

import com.shixun.dao.BookDao;
import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 19:03
 * @version: 1.0
 * @modified By:
 */
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBookList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        List<Book> bookList = new ArrayList<>();

        conn = DruidUtil.getInstance().getConnection();
        sql = "SELECT * FROM book";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String bookTitle = rs.getString("book_title");
            String bookNum = rs.getString("book_num");
            String bookAuthor = rs.getString("book_author");
            Book book = new Book(bookId,bookTitle,bookNum,bookAuthor);
            bookList.add(book);
        }

        DruidUtil.getInstance().closeConnection(conn);

        return bookList;
    }

    @Override
    public boolean addBook(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "INSERT INTO book(book_title, book_num, book_author) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookTitle());
        pstmt.setString(2, book.getBookNum());
        pstmt.setString(3, book.getBookAuthor());

        int flagTemp = pstmt.executeUpdate();
        if (flagTemp > 0){
            flag = true;
            System.out.println("insert successful");
        }else {
            System.out.println("insert failed");
        }

        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }

    @Override
    public boolean deleteBook(int bookId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "DELETE FROM book WHERE book_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookId);

        int flagTemo = pstmt.executeUpdate();

        if (flagTemo > 0){
            System.out.println("delete successful");
            flag = true;
        }else {
            System.out.println("delete failed");
        }
        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }

    @Override
    public List<Book> searchBook(String title) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        List<Book> bookList = new ArrayList<>();

        conn = DruidUtil.getInstance().getConnection();
        sql = "SELECT * FROM book WHERE book.book_title LIKE concat('%', ?, '%')";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        rs = pstmt.executeQuery();

        while (rs.next()){
            int bookId = rs.getInt("book_id");
            String bookTitle = rs.getString("book_title");
            String bookNum = rs.getString("book_num");
            String bookAuthor = rs.getString("book_author");
            Book book = new Book(bookId,bookTitle,bookNum,bookAuthor);
            bookList.add(book);
        }

        DruidUtil.getInstance().closeConnection(conn);
        return bookList;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        boolean flag = false;

        conn = DruidUtil.getInstance().getConnection();
        sql = "UPDATE `shixun`.`book` SET `book_title` = ?, `book_num` = ?, `book_author` = ? WHERE `book_id` = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookTitle());
        pstmt.setString(2, book.getBookNum());
        pstmt.setString(3, book.getBookAuthor());
        pstmt.setInt(4, book.getBookId());

        int flagTemp = pstmt.executeUpdate();
        if (flagTemp > 0){
            System.out.println("update successful");
            flag = true;
        }else {
            System.out.println("update failed");
        }

        DruidUtil.getInstance().closeConnection(conn);
        return flag;
    }
}
