package org.example.magnificentgallery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Alert alert = new Alert(Alert.AlertType.ERROR);
 //   @FXML
//    private Image image = new Image("Screenshot.png");
    @FXML
    ImageView img = new ImageView();


@FXML
    protected void onHelloButtonClick() {

    //img.setImage(image);
        alert.show();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}