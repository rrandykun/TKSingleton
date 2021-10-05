package com.graphicacode;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String url = "jdbc:mysql://localhost/mylibrary";
    private String user = "root";
    private String pass = "telkom";
    private Connection con;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return con;
    }

    public static DatabaseConnection getInstance() throws SQLException {

        if (instance == null) {

                instance = new DatabaseConnection();

        } else if (instance.getConnection().isClosed()) {

                instance = new DatabaseConnection();

        }
        return instance;
    }
}