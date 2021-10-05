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
    public void update(Book book)
        throws SQLException;
}