package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sessionRepository {

    public int getUser() {
        int userId = -1;
        String sql = "Select * from session";
        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                userId = Integer.parseInt(rs.getString("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public void setUser(int userId){
        String sql = "update session set user_id = ?";

        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
