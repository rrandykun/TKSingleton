package com.graphicacode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImplementation
    implements BookDao {

    Connection con;

    {
        try {
            con = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int add(Book book)
        throws SQLException
    {
        String query
            = "INSERT INTO `book_data`(`book_name`, `book_code`, `status`) VALUES (?,?,?)";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, book.getBook_name());
        ps.setString(2, book.getBook_code());
        ps.setString(3, book.getStatus());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(String book_code)
        throws SQLException
    {
        String query
            = "delete from book_data where book_code =?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, book_code);
        ps.executeUpdate();
    }

    @Override
    public Book getBook(String book_code)
        throws SQLException
    {

        String query
            = "select * from book_data where book_code= ?";
        PreparedStatement ps
            = con.prepareStatement(query);

        ps.setString(1, book_code);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            book.setBook_id(rs.getInt("id"));
            book.setBook_name(rs.getString("book_name"));
            book.setBook_code(rs.getString("book_code"));
        }

        if (check == true) {
            return book;
        }
        else
            return null;
    }

    @Override
    public List<Book> getBooks()
        throws SQLException
    {
        String query = "select * from book_data";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> ls = new ArrayList();

        while (rs.next()) {
            Book book = new Book();
            book.setBook_id(rs.getInt("id"));
            book.setBook_name(rs.getString("book_name"));
            book.setBook_code(rs.getString("book_code"));
            book.setDate_in(rs.getString("date_in"));
            book.setStatus(rs.getString("status"));
            ls.add(book);
        }
        return ls;
    }

    @Override
    public void update(Book book)
        throws SQLException
    {

        String query
            = "update book_data set book_name=?, "+ " book_code= ? where id = ?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, book.getBook_name());
        ps.setString(2, book.getBook_code());
        ps.setInt(3, book.getBook_id());
        ps.executeUpdate();
    }
}