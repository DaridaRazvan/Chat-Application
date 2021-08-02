package gui;

import domain.Message;
import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import repository.messageRepository;
import repository.userRepository;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindow {
    @FXML
    ImageView logOutButton;

    @FXML
    ListView listView;

    @FXML
    ImageView imagePlus;

    @FXML
    ImageView imageFriends;

    @FXML
    ImageView imageBubble;

    @FXML
    ImageView imageSend;

    private User user;

    Image hoverExit_plus = new Image("photos/plus.png");
    Image hoverEnter_plus = new Image("photos/plus_orange.png");
    Image hoverExit_friends = new Image("photos/friends.png");
    Image hoverEnter_friends = new Image("photos/friends_orange.png");
    Image hoverExit_bubble = new Image("photos/speech-bubbles-with-ellipsis.png");
    Image hoverEnter_bubble = new Image("photos/speech-bubbles-with-ellipsis_orange.png");
    Image hoverExit_logout = new Image("photos/logout.png");
    Image hoverEnter_logout = new Image("photos/logout_orange.png");
    Image hoverExit_send = new Image("photos/send.png");
    Image hoverEnter_send = new Image("photos/send_orange.png");

    public void initialize(){
    }

    public void addUsers(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addUsers.fxml"));
            Parent root = fxmlLoader.load();
            imagePlus.setImage(hoverExit_plus);
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

    public void showMessages()
    {
        listView.getItems().clear();
        ObservableList<User> userList = FXCollections.observableArrayList();
        messageRepository messageRepository = new messageRepository();
        userRepository userRepository = new userRepository();
        ArrayList<Integer> users = messageRepository.getUserMessage(user);
        for(int u : users)
        {
            userList.add(userRepository.getUser(u));
        }
        listView.setItems(userList);
    }
    public void whenHoverEnterPlus()
    {
        imagePlus.setImage(hoverEnter_plus);
    }
    public void whenHoverExitPlus()
    {
        imagePlus.setImage(hoverExit_plus);
    }
    public void whenHoverEnterFriends()
    {
        imageFriends.setImage(hoverEnter_friends);
    }
    public void whenHoverExitFriends()
    {
        imageFriends.setImage(hoverExit_friends);
    }
    public void whenHoverEnterBubble()
    {
        imageBubble.setImage(hoverEnter_bubble);
    }
    public void whenHoverExitBubble()
    {
        imageBubble.setImage(hoverExit_bubble);
    }
    public void whenHoverEnterLogOut()
    {
        logOutButton.setImage(hoverEnter_logout);
    }
    public void whenHoverExitLogOut()
    {
        logOutButton.setImage(hoverExit_logout);
    }
    public void whenHoverEnterSend()
    {
        imageSend.setImage(hoverEnter_send);
    }
    public void whenHoverExitSend()
    {
        imageSend.setImage(hoverExit_send);
    }
}
