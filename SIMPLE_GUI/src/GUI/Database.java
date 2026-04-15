package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // it26 is the name of your database in XAMPP
            String url = "jdbc:mysql://localhost:3306/it26"; 
            String user = "root"; 
            String password = ""; // Default XAMPP password is empty

            // Load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
        return conn;
    }
}