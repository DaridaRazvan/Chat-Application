package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private final Connection connection;

    public dbConnection() throws SQLException{
        String link = "jdbc:postgresql://localhost:5432/Chat Application";
        String username = "postgres";
        String password = "postgre";
        connection = DriverManager.getConnection(link, username, password);
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try{
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
