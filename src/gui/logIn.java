package gui;

import exception.CustomException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.userService;

public class logIn {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    public void signInPressed(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        userService userService = new userService();
        if(!userService.checkUser(username,password)) {
            CustomException customException = new CustomException("Error!","Invalid data!","Wrong username or password!");
            customException.show();
        }

    }

    public void signUpPressed(){

    }
}
