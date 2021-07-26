package gui;

import exception.AlertMsg;
import exception.CustomException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.userService;


public class signUp {


    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    PasswordField confirmPasswordField;

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    ImageView imageView;


    public void addUser(){
        String pass = passwordField.getText();
        String passCheck = confirmPasswordField.getText();

        if(!pass.equals(passCheck))
        {
            CustomException customException = new CustomException("Error","ur mom!","Passwords don't match");
            customException.show();
            return;
        }

        String username = usernameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        userService userService = new userService();
        if(userService.addUser(username,pass,firstName,lastName))
        {
            AlertMsg alertMsg = new AlertMsg("Congrats!","Account created!","Gj wp");
            alertMsg.show();
        }
    }

    public void initialize()
    {
        showImage();
    }

    public void showImage() {
        try {
            Image image = new Image("wp4410739.jpg");
            imageView.setImage(image);
            imageView.setCache(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
