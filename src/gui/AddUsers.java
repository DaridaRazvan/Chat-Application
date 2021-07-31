package gui;

import domain.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import repository.userRepository;

public class AddUsers {
    @FXML
    ListView listView;

    public User user;

    public void initialize(){
        populateList();
    }

    public void setUser(User user){
        this.user = user;
    }


    public void populateList(){
        userRepository userRepo = new userRepository();
        ObservableList<String> items = userRepo.getUsersName(0);
        listView.setItems(items);
    }
}
