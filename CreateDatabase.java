package Classwork;
import java.sql.*;
public class CreateDatabase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/?";
            String username = "root";
            String password = "aryanaitikrajput15";
            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "CREATE DATABASE IF NOT EXISTS sem3";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Database Created ");
            connection.close();
        }catch (Exception e){
            System.out.println("Error"+e);
        }
    }
}
