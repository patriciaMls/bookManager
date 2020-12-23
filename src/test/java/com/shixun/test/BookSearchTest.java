package com.shixun.test;

import com.shixun.entity.Book;
import com.shixun.utils.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/23 10:13
 * @version: 1.0
 * @modified By:
 */
public class BookSearchTest {
    @Test
    public void searchBook() throws SQLException {
        String title = "夜";
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
        System.out.println("111"+bookList);
        DruidUtil.getInstance().closeConnection(conn);
    }

    @Test
    public void addBook() throws SQLException {
        Book book = new Book();
        book.setBookTitle("毛姆读书笔记");
        book.setBookNum("GB7000");
        book.setBookAuthor("毛姆");

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

        int flagtemp = pstmt.executeUpdate();
        if (flagtemp > 0){
            flag = true;
            System.out.println("insert successful");
        }else {
            System.out.println("insert failed");
        }
    }

    @Test
    public void updateBook() throws SQLException {
        Book book = new Book();
        book.setBookId(7);
        book.setBookTitle("毛姆读书笔记");
        book.setBookNum("GB7000");
        book.setBookAuthor("W.S.毛");

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
        System.out.println(flag);
    }
}
