package com.graphicacode;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public int add(Book emp)
        throws SQLException;
    public void delete(String book_code)
        throws SQLException;
    public Book getBook(String book_code)
        throws SQLException;
    public List<Book> getBooks()
        throws SQLException;
    public void update(String book_name, String book_code, String status)
        throws SQLException;

    public void rentBook(String book_code, String user_id)
            throws SQLException;
    public void returnBook(String book_code, String user_name)
            throws SQLException;
}