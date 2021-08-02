package repository;

import domain.Message;
import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class messageRepository {

    public void addMessage()
    {

    }

    public ObservableList<Message> getMessages(User user1, User user2)
    {
        ObservableList<Message> messages = FXCollections.observableArrayList();
        String sql = "Select * from messages where (userid1 = "+ user1.getId() +" and userid2 =" + user2.getId() +" ) or (userid1 =" + user2.getId() +" and userid2= " + user1.getId()+")";
        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                messages.add(new Message(rs.getInt("userid1"),rs.getInt("userid2"), rs.getString("message")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return messages;

    }

    public ArrayList<Integer> getUserMessage(User user)
    {
        ArrayList<Integer> userId = new ArrayList<>();
        String sql = "Select userid1, userid2 from messages where userid1 = " + user.getId() + "or userid2 = " + user.getId();
        try(Connection connection = new dbConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
               int id1 = rs.getInt("userid1");
               int id2 = rs.getInt("userid2");
               if(id1 == user.getId() && !userId.contains(id2))
                   userId.add(id2);
               else{
                   if(!userId.contains(id1))
                    userId.add(id1);
               }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return userId;
    }


}
