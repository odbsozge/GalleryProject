package org.example.magnificentgallery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.Notifications;
import org.example.magnificentgallery.Entity.Cart;
import org.example.magnificentgallery.Entity.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloController {


    @FXML
    private Label label;
    @FXML
    private Label welcomeText;
    @FXML
    private Label amount;

    @FXML
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private Image image;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView tableView;
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
    @FXML
    private Button addCartButton;
    @FXML
    private HBox cartInfo;

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
        User user = service.GetUser(inputEmail.getText());
        if (user != null) {
            welcomeText.setText("Hello " + user.getFirstName() + " " + user.getLastName());
            welcomeText.setVisible(true);

            inputEmail.setVisible(false);
            imageView.setVisible(true);
            imageView.setFitWidth(350);
            imageView.setFitHeight(250);

            loginButton.setVisible(false);
            cartButton.setVisible(true);
            backButton.setVisible(true);
            nextButton.setVisible(true);
            addCartButton.setVisible(true);

            if (label.getText().equals("LOGIN")) {
                label.setText("Paintings");
            }

            try {
                imageView.setImage(new Image(new FileInputStream(urlList[0])));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            alert.setContentText("Bu emaile ait kullanıcı bulunmamaktadır!");
            alert.setAlertType(Alert.AlertType.ERROR);
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

        if (label.getText().equals("Login")) {
            label.setText("Paintings");
        }
    }

    @FXML
    protected void onClickCartButton() {

        //sepeti kapatırken
        if (label.getText().equals("Cart")) {
            label.setText("Paintings");
            cartButton.setText("Cart");
            backButton.setVisible(true);
            nextButton.setVisible(true);
            addCartButton.setVisible(true);

            imageView.setVisible(true);
            imageView.setFitWidth(350);
            imageView.setFitHeight(250);

            tableView.setVisible(false);
            tableView.prefWidth(0);
            tableView.prefHeight(0);

            cartInfo.setVisible(false);
            cartInfo.prefWidth(0);
            cartInfo.prefHeight(0);
        }
        //sepeti açarken
        else {
            label.setText("Cart");
            cartButton.setText("Paintings");
            backButton.setVisible(false);
            nextButton.setVisible(false);
            addCartButton.setVisible(false);

            imageView.setVisible(false);
            imageView.setFitWidth(0);
            imageView.setFitHeight(0);

            tableView.setVisible(true);
            tableView.setMaxSize(600,450);
            tableView.setPrefHeight(450);
            var cart = service.GetCart();
            ObservableList<Cart> observableCartList = FXCollections.observableArrayList(cart);
            tableView.setItems(observableCartList);
            tableView.refresh();

            cartInfo.setVisible(true);
            cartInfo.prefWidth(400);
            cartInfo.prefHeight(50);
            amount.setText("Amount : " + service.GetTotalPrice(1));
        }
    }

    @FXML
    public void addCartButtonClick() {
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ürün başarıyla sepete eklendi.");
        alert.show();
    }

    @FXML
    public void onClickBuyButton() {
        alert.show();
    }

}