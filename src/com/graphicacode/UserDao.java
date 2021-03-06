package com.graphicacode;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	public int add(User emp)
        throws SQLException;
    public void delete(int user_id)
        throws SQLException;
    public User getUser(int user_id)
        throws SQLException;
    public List<User> getUsers()
        throws SQLException;
    public void update(int user_id, String nama_peminjam, String notelp, String email)
        throws SQLException;
}
