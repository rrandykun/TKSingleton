package com.graphicacode;

import java.sql.SQLException;
import java.util.List;

public interface PustakawanDao {
    public int add(Pustakawan emp)
            throws SQLException;
    public void delete(int idPetugas)
            throws SQLException;
    public User getUser(int idPetugas)
            throws SQLException;
    public List<User> getUsers()
            throws SQLException;
    public void update(String namaPetugas, int idPetugas)
            throws SQLException;
}