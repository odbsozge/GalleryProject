package org.example.magnificentgallery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.example.magnificentgallery.Entity.Cart;
import org.example.magnificentgallery.Entity.Customer;

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
    private Alert info = new Alert(Alert.AlertType.INFORMATION);

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
    private Button infoButton;
    @FXML
    private Button addCartButton;
    @FXML
    private Button buyButton;
    @FXML
    private HBox cartInfo;
    @FXML
    private HBox buttons;
    @FXML
    private HBox loginButtonBox;

    private int currentIndex = 0;
    private String[] urlList = {
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Guernica.jpg",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/monalisa.jpg",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/sonakşamyemeği.jpg",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/yıldızlıgece.jpg",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/çığlık.jpg",
            "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/öpücük.jpg"
    };

    Service service = new Service();

    @FXML
    protected void onClickLoginButton() {
        Customer customer = service.GetUser(inputEmail.getText());
        if (customer != null) {
            welcomeText.setText(STR."Hello \{customer.getFirstName()} \{customer.getLastName()}");
            welcomeText.setVisible(true);

            inputEmail.setVisible(false);
            inputEmail.setMaxHeight(0);
            inputEmail.setMaxWidth(0);
            imageView.setVisible(true);
            imageView.setFitWidth(550);
            imageView.setFitHeight(450);

            loginButton.setVisible(false);
            loginButtonBox.setManaged(false);
            cartButton.setVisible(true);
            backButton.setVisible(true);
            nextButton.setVisible(true);
            infoButton.setVisible(true);
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
            buyButton.setVisible(false);
            backButton.setVisible(true);
            nextButton.setVisible(true);
            infoButton.setVisible(true);
            addCartButton.setVisible(true);
            buttons.setManaged(true);
            infoButton.setManaged(true);
            addCartButton.setManaged(true);
            imageView.setManaged(true);
            imageView.setVisible(true);
            imageView.setFitWidth(550);
            imageView.setFitHeight(450);

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
            buyButton.setVisible(true);
            backButton.setVisible(false);
            nextButton.setVisible(false);
            infoButton.setVisible(false);
            addCartButton.setVisible(false);

            buttons.setManaged(false);
            infoButton.setManaged(false);
            addCartButton.setManaged(false);

            imageView.setManaged(false);
            imageView.setVisible(false);
            imageView.setFitWidth(0);
            imageView.setFitHeight(0);

            tableView.setVisible(true);
            tableView.setMaxSize(700,450);
            tableView.setPrefHeight(450);

            var cart = service.GetCart();
            ObservableList<Cart> observableCartList = FXCollections.observableArrayList(cart);
            tableView.setItems(observableCartList);
            tableView.refresh();

            cartInfo.setVisible(true);
            cartInfo.prefWidth(400);
            cartInfo.prefHeight(50);
            amount.setText(STR."Amount : \{service.GetTotalPrice(1)}");
        }
    }

    @FXML
    public void infoButtonClick() {
        info.setTitle("Information");
        info.setHeaderText("Information");
        info.setContentText("starry night");
        info.show();

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