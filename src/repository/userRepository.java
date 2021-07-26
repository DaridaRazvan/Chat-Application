package repository;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRepository {
    public void addUser(User user){
        String sql = "insert into users (username, password, firstname, lastname) values (?, ?, ?, ?)";

        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateUser(){

    }

    public void deleteUser(){

    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        String sql = "Select * from users";

        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    public boolean checkUser(String username, String password){
        String sql = "Select username, password from users";

        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                if(rs.getString("username").equals(username))
                    if(rs.getString("password").equals(password))
                        return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
