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
	            = "INSERT INTO `user_data`(`nama_peminjam`, `status`) VALUES (?,?)";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, user.getNama_peminjam());
	        ps.setString(2, user.getStatus());
	        int n = ps.executeUpdate();
	        return n;
	    }

	    @Override
	    public void delete(int user_id)
	        throws SQLException
	    {
	        String query
	            = "delete from user_data where id =?";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setInt(1, user_id);
	        ps.executeUpdate();
	    }

	    @Override
	    public User getUser(int user_id)
	        throws SQLException
	    {

	        String query
	            = "select * from user_data where id= ?";
	        PreparedStatement ps
	            = con.prepareStatement(query);

	        ps.setInt(1, user_id);
	        User user = new User();
	        ResultSet rs = ps.executeQuery();
	        boolean check = false;

	        while (rs.next()) {
	            check = true;
	            user.setUser_id(rs.getInt("id"));
	            user.setNama_peminjam(rs.getString("nama_peminjam"));
	            user.setStatus(rs.getString("status"));
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
	        String query = "select * from user_data";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        List<User> ls_user = new ArrayList();

	        while (rs.next()) {
	            User user = new User();
	            user.setUser_id(rs.getInt("id"));
	            user.setNama_peminjam(rs.getString("nama_peminjam"));
	            user.setStatus(rs.getString("status"));
	            ls_user.add(user);
	        }
	        return ls_user;
	    }

	    @Override
	    public void update(String nama_peminjam, String status, int user_id)
	            throws SQLException
	    {
	        String query
	            = "update user_data set nama_peminjam=?, "+ " status= ? where id = ?";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, nama_peminjam);
	        ps.setString(2, status);
	        ps.setInt(3, user_id);
	        ps.executeUpdate();
	    }
}
