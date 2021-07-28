package gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import repository.userRepository;

public class AddUsers {
    @FXML
    ListView listView;

    public void initialize(){
        populateList();
    }

    public void populateList(){
        userRepository userRepo = new userRepository();
        ObservableList<String> items = userRepo.getUsersName();
        listView.setItems(items);
    }
}
