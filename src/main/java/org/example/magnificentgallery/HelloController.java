package org.example.magnificentgallery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Image image;
    @FXML
    private ImageView imageView;

    private int currentIndex = 0;
    private String[] urlList = {
        "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot2.png",
                "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot3.png"
    };


    @FXML
    protected void onHelloButtonClick() {
        try {
            imageView.setImage(new Image(new FileInputStream(urlList[currentIndex])));
            currentIndex += 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (welcomeText.getText().equals("merhaba dünya")) {
            welcomeText.setText("hi");
        } else {

            welcomeText.setText("hello");
        }
    }
}