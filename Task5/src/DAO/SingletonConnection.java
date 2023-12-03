package DAO;

import java.sql.*;

public class SingletonConnection {

    private static volatile SingletonConnection instance;
    private Connection connection;

    private SingletonConnection() {
        final String url = "jdbc:mysql://localhost:3306/db_studentmanagementsystem";
        final String username = "root";
        final String password = "";

        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish a database connection", e);
        }
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            synchronized (SingletonConnection.class) {
                if (instance == null) {
                    instance = new SingletonConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}


