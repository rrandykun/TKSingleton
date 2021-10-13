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
            = "INSERT INTO `tbl_buku`(`judul`, `penerbit`, `tahun`, `status`) VALUES (?,?,?,?)";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, book.getJudul());
        ps.setString(2, book.getPenerbit());
        ps.setInt(3, book.getTahun());
        ps.setString(4, book.getStatus());
        int n = ps.executeUpdate();
        if (n > 0) {
            System.out.println("Data buku berhasil ditambahkan.");
         }
        return n;
    }

    @Override
    public void delete(int book_code)
        throws SQLException
    {
        String query
            = "delete from tbl_buku where kdBuku =?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setInt(1, book_code);
        int n = ps.executeUpdate();
        if (n > 0) {
            System.out.println("Data buku berhasil dihapus.");
        }else{
            System.out.println("Kode buku tidak ditemukan.");
        }
    }

    @Override
    public Book getBook(int book_code)
        throws SQLException
    {

        String query
            = "select * from tbl_buku where kdBuku= ?";
        PreparedStatement ps
            = con.prepareStatement(query);

        ps.setInt(1, book_code);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            book.setkdBuku(rs.getInt("kdBuku"));
            book.setJudul(rs.getString("judul"));
            book.setPenerbit(rs.getString("penerbit"));
            book.setTahun(rs.getInt("tahun"));
            book.setStatus(rs.getString("status"));
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
        String query = "select * from tbl_buku";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> ls = new ArrayList();
        if (rs.next() == false) {
            System.out.println("Data Buku masih kosong.");
        } else {
            do {
                Book book = new Book();
                book.setkdBuku(rs.getInt("kdBuku"));
                book.setJudul(rs.getString("judul"));
                book.setPenerbit(rs.getString("penerbit"));
                book.setTahun(rs.getInt("tahun"));
                book.setStatus(rs.getString("status"));
                ls.add(book);
            } while (rs.next());
        }

        return ls;
    }

    @Override
    public void update(int kdBuku, String book_name, String penerbit, int tahun, String status)
            throws SQLException
    {

        String query
                = "update tbl_buku set judul=?, "+ " penerbit= ?, "+" tahun= ?, "+ " status= ? where kdBuku = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, book_name);
        ps.setString(2, penerbit);
        ps.setInt(3, tahun);
        ps.setString(4, status);
        ps.setInt(5, kdBuku);
        int n = ps.executeUpdate();
        if (n > 0) {
            System.out.println("Data buku berhasil diupdate.");
        }else{
            System.out.println("Kode buku tidak ditemukan.");
        }
    }

    @Override
    public void rentBook(int kdBuku, int idUser, String tglPinjam)
            throws SQLException
    {
        String query
                = "INSERT INTO `tbl_transaksi`(`kdBuku`, `idUser`, `tglPinjam` ) VALUES (?,?,?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, kdBuku);
        ps.setInt(2, idUser);
        ps.setString(3, tglPinjam);
        ps.executeUpdate();

        String query1
                = "update tbl_buku set status='rent' where kdBuku = ?";
        PreparedStatement ps1
                = con.prepareStatement(query1);
        ps1.setInt(1, kdBuku);
        ps1.executeUpdate();

        int n = ps1.executeUpdate();
        if (n > 0) {
            System.out.println("Peminjaman sukses.");
        }else{
            System.out.println("Peminjaman gagal.");
        }
    }

    @Override
    public void returnBook(int idUser, int kdBuku, String tglKembali)
            throws SQLException
    {
        String query
                = "UPDATE tbl_transaksi set tglKembali=? WHERE idUser=? AND kdBuku=?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, tglKembali);
        ps.setInt(2, idUser);
        ps.setInt(3, kdBuku);
        ps.executeUpdate();

        String query1
                = "Update tbl_buku set status='available' where kdBuku=? ";
        PreparedStatement ps1
                = con.prepareStatement(query1);
        ps1.setInt(1, kdBuku);
        int n = ps1.executeUpdate();
        if (n > 0) {
            System.out.println("Pengembalian sukses.");
        }else{
            System.out.println("Pengembalian gagal.");
        }
    }


}