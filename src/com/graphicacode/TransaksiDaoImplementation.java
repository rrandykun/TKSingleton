package com.graphicacode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDaoImplementation implements  TransaksiDao{

    Connection con;

    {
        try {
            con = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            int n = ps.executeUpdate();
            if (n > 0) {
                String query1
                        = "Update tbl_buku set status='available' where kdBuku=? ";
                PreparedStatement ps1
                        = con.prepareStatement(query1);
                ps1.setInt(1, kdBuku);
                n = ps1.executeUpdate();

                System.out.println("Pengembalian sukses.");
            }else{
                System.out.println("Pengembalian gagal.");
            }
    }
    @Override
    public List<Transaksi> getRents(int idUser) throws SQLException{
        String query = "select * from tbl_transaksi where idUser=? AND tglKembali IS NULL";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
       List<Transaksi> ls_trans = new ArrayList();

        boolean check = false;

        while (rs.next()) {
            check = true;
            Transaksi trans = new Transaksi();
            trans.setId(rs.getInt("id"));
            trans.setIdUser(rs.getInt("idUser"));
            trans.setIdUser(rs.getInt("idUser"));
            trans.setKdBuku(rs.getInt("kdBuku"));
            trans.setTglPinjam(rs.getString("tglPinjam"));
            ls_trans.add(trans);
        }

        if (check == true) {
            return ls_trans;
        }else{
            return null;
        }
    }
}


