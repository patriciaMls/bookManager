package com.shixun.entity;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 18:59
 * @version: 1.0
 * @modified By:
 */
public class Book {
    private  int bookId;
    private String bookTitle;
    private String bookNum;
    private String bookAuthor;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookNum, String bookAuthor) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookNum = bookNum;
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookNum='" + bookNum + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
