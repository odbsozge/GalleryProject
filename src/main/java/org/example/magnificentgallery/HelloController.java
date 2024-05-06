package org.example.magnificentgallery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Alert alert = new Alert(Alert.AlertType.ERROR);
    @FXML
    private Image image;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField inputEmail;
    @FXML
    private Button loginButton;
    @FXML
    private Button cartButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;

    private int currentIndex = 0;
    private String[] urlList = {
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot.png",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot2.png",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot3.png",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot4.png",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Screenshot5.png"
    };



    Service service = new Service();
    @FXML
    protected void onClickLoginButton() {
        if (service.GetUser(inputEmail.getText()) != null){
        inputEmail.setVisible(false);

        imageView.setVisible(true);
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        loginButton.setVisible(false);
        cartButton.setVisible(true);
        backButton.setVisible(true);
        nextButton.setVisible(true);

        if (welcomeText.getText().equals("LOGIN")) {
            welcomeText.setText("Paintings");
        }

        try {
            imageView.setImage(new Image(new FileInputStream(urlList[0])));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        }
        else {
            alert.setContentText("Bu emaile ait kullanıcı bulunmamaktadır!");
            alert.show();
        }
    }

    @FXML
    protected void goNextButtonClick() {
        try {
            if (currentIndex != (urlList.length - 1)) {
                currentIndex += 1;
            }

            imageView.setImage(new Image(new FileInputStream(urlList[currentIndex])));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    protected void goBackButtonClick() {
        try {
            if (currentIndex != 0) {
                currentIndex -= 1;
            }
            imageView.setImage(new Image(new FileInputStream(urlList[currentIndex])));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (welcomeText.getText().equals("Login")) {
            welcomeText.setText("Paintings");
        }
    }

    @FXML
    protected void onClickCartButton() {

        if (welcomeText.getText().equals("Cart")) {
            welcomeText.setText("Paintings");
        } else {
            welcomeText.setText("Cart");
        }
    }
}