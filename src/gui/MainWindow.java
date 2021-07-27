package gui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainWindow {
    @FXML
    ImageView exitImage;

    @FXML
    ImageView friendsImage;

    @FXML
    ImageView speechImage;


    public void initialize()
    {
        showImage();
    }

    public void showImage() {
        try {
            Image logout = new Image("photos/logout.jpg");
            Image friends = new Image("photos/friends.jpg");
            Image speech = new Image("photos/speech-bubbles-with-ellipsis.jpg");
            exitImage.setImage(logout);
            friendsImage.setImage(friends);
            speechImage.setImage(speech);
            exitImage.setCache(true);
            friendsImage.setCache(true);
            speechImage.setCache(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
