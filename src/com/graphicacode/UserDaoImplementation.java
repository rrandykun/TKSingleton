package com.graphicacode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation 
	implements UserDao {

	    Connection con;

	    {
	        try {
	            con = DatabaseConnection.getInstance().getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    @Override
	    public int add(User user)
	        throws SQLException
	    {
	        String query
	            = "INSERT INTO `tbl_user`(`nama`, `noTelp`, `email`) VALUES (?,?,?)";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, user.getNama_peminjam());
	        ps.setString(2, user.getNoTelp());
	        ps.setString(3, user.getEmail());
	        int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Data peminjam berhasil ditambahkan.");
			}
			return n;
	    }

	    @Override
	    public void delete(int user_id)
	        throws SQLException
	    {
	        String query
	            = "delete from tbl_user where idUser =?";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setInt(1, user_id);
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Data peminjam berhasil dihapus.");
			}else{
				System.out.println("ID peminjam tidak ditemukan.");
			}
	    }

	    @Override
	    public User getUser(int user_id)
	        throws SQLException
	    {

	        String query
	            = "select * from tbl_user where idUser= ?";
	        PreparedStatement ps
	            = con.prepareStatement(query);

	        ps.setInt(1, user_id);
	        User user = new User();
	        ResultSet rs = ps.executeQuery();
	        boolean check = false;

	        while (rs.next()) {
	            check = true;
	            user.setUser_id(rs.getInt("idUser"));
	            user.setNama_peminjam(rs.getString("nama"));
	            user.setNoTelp(rs.getString("noTelp"));
                user.setEmail(rs.getString("email"));
	        }

	        if (check == true) {
	            return user;
	        }
	        else
	            return null;
	    }

	    @Override
	    public List<User> getUsers()
	        throws SQLException
	    {
	        String query = "select * from tbl_user";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        List<User> ls_user = new ArrayList();
			if (rs.next() == false) {
				System.out.println("Data Peminjam masih kosong.");
			} else {
				do {
					User user = new User();
					user.setUser_id(rs.getInt("idUser"));
					user.setNama_peminjam(rs.getString("nama"));
                    user.setNoTelp(rs.getString("noTelp"));
                    user.setEmail(rs.getString("email"));
					ls_user.add(user);
				} while (rs.next());
			}

	        return ls_user;
	    }

	    @Override
	    public void update(int user_id, String nama_peminjam, String notelp, String email)
	            throws SQLException
	    {
	        String query
	            = "update tbl_user set nama=?, "+ " noTelp= ?, "+ " email= ? where idUser = ?";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, nama_peminjam);
	        ps.setString(2, notelp);
			ps.setString(3, email);
	        ps.setInt(4, user_id);
	        int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("Data peminjam berhasil diupdate.");
			}else{
				System.out.println("ID peminjam tidak ditemukan.");
			}
	    }
}
