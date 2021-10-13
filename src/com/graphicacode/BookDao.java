package com.graphicacode;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public int add(Book emp)
        throws SQLException;
    public void delete(int book_code)
        throws SQLException;
    public Book getBook(int book_code)
        throws SQLException;
    public List<Book> getBooks()
        throws SQLException;
    public void update(int kdBuku, String book_name, String penerbit, int tahun, String status)
        throws SQLException;

    public void rentBook(int kdBuku, int idUser, String tglPinjam)
            throws SQLException;
    public void returnBook(int kdBuku, int idUser, String tglKembali)
            throws SQLException;
}