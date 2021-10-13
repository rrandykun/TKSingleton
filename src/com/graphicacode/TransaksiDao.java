package com.graphicacode;

import java.sql.SQLException;
import java.util.List;

public interface TransaksiDao {
    public void rentBook(int kdBuku, int idUser, String tglPinjam)
            throws SQLException;
    public void returnBook(int kdBuku, int idUser, String tglKembali)
            throws SQLException;
    public List<Transaksi> getRents(int idUser)
            throws SQLException;
}
