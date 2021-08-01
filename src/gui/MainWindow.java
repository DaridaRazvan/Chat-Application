package gui;

import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import repository.userRepository;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindow {
    @FXML
    ImageView logOutButton;

    @FXML
    ListView listView;

    private User user;

    public void initialize(){
    }

    public void addUsers(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addUsers.fxml"));
            Parent root = fxmlLoader.load();

            AddUsers addUsers = fxmlLoader.getController();
            addUsers.populateList(user);

            Stage stage = new Stage();
            stage.setScene(new Scene(root,400,400));
            stage.setTitle("Choose an user!");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOutPressed()
    {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
    }

    public void setUser(String username, String password) {
        userRepository userRepository = new userRepository();
        user = userRepository.getUser(username,password);
    }

    public void setTitle(Stage stage){
        stage.setTitle("Welcome " + user.getFirstName() + " " + user.getLastName() + "!");
    }

    public void setFriendList(){
        System.out.println(user);
        listView.getItems().clear();
        ObservableList<User> friendList = FXCollections.observableArrayList();
        userRepository userRepository = new userRepository();
        ArrayList<Integer> friendListId = userRepository.getUserFriends(user);
        friendListId.forEach(System.out::println);
        for(Integer f : friendListId){
            friendList.add(userRepository.getUser(f));
        }
        listView.setItems(friendList);
    }
}
