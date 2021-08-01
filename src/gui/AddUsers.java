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

    }

    public void setUser(User user){
        this.user = user;
    }


    public void populateList(User user){
        userRepository userRepo = new userRepository();
        setUser(user);
        //ObservableList<String> items = userRepo.getUsersName(user.getId());
        ObservableList<User> items = userRepo.getUsersName(user.getId());
        listView.setItems(items);
    }
}
