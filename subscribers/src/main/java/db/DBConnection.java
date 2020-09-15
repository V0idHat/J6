package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscribers","root", "toor");
            System.out.println("Connection Established...");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void close(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
