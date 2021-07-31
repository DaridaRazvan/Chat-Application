package gui;

import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import repository.userRepository;

import java.io.IOException;

public class MainWindow {
    @FXML
    ImageView logOutButton;

    private User user;

    public void initialize(){
        //Stage stage = (Stage) logOutButton.getScene().getWindow();
        //stage.setTitle("Welcome" + user.getFirstName() + " " + user.getLastName());
    }

    public void addUsers(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addUsers.fxml"));
            Parent root = fxmlLoader.load();

            AddUsers addUsers = fxmlLoader.getController();
            addUsers.setUser(user);

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

    public void setFriendList(){
        System.out.println(user);
    }
}
