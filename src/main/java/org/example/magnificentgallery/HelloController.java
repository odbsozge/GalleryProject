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
import org.example.magnificentgallery.Entity.Customer;
import org.example.magnificentgallery.Entity.Painting;

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
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Alert info = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ImageView imageView;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn NameColumn;
    @FXML
    private TableColumn PriceColumn;
    @FXML
    private TableColumn ArtistColumn;
    @FXML
    private TableColumn YearColumn;
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
    private int currentIndex = 1;
    Service service = new Service();
    Customer loginCustomer;
    LinkedListNode customerCart = new LinkedListNode();


    @FXML
    protected void onClickLoginButton() {
        Customer customer = service.GetUser(inputEmail.getText());
        if (customer != null) {
            loginCustomer = new Customer((int) customer.getId(), customer.getFirstName(), customer.getLastName(), (double) customer.getLoan(), customer.getEmail());
            welcomeText.setText(STR."Hello \{loginCustomer.getFirstName()} \{loginCustomer.getLastName()}");
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
                var urlList = service.getPaintingUrlList();
                imageView.setImage(new Image(new FileInputStream(urlList[currentIndex])));
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
            var urlList = service.getPaintingUrlList();
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
            var urlList = service.getPaintingUrlList();

            if (currentIndex != 1) {
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
    public void infoButtonClick() {
        info.setTitle("Information");
        info.setHeaderText("Information");
        var paintingUrlList = service.getPaintingUrlList();
        var tree = service.getPaintingTree();
        var paintings = tree.getAllChilds();
        var painting = paintings.stream().filter(item -> item.getPainting().getUrl().equals(paintingUrlList[currentIndex])).findFirst().orElse(null);
        if (painting != null) {
            info.setContentText(STR." Name: \{painting.getPainting().getName()}\n Artist: \{painting.getPainting().getArtist()}\n Year: \{painting.getPainting().getYear()}\n Price: \{painting.getPainting().getPrice()}");
        }
        info.show();

    }

    @FXML
    public void addCartButtonClick() {
        var paintingUrlList = service.getPaintingUrlList();
        var tree = service.getPaintingTree();
        var paintings = tree.getAllChilds();
        var painting = paintings.stream().filter(item -> item.getPainting().getUrl().equals(paintingUrlList[currentIndex])).findFirst().orElse(null);
        if (painting != null) {
            customerCart.addPainting(painting.getPainting());
        }

        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText("Ürün başarıyla sepete eklendi.");
        alert.show();
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
            tableView.setMaxSize(700, 450);
            tableView.setEditable(true);
            tableView.setPrefHeight(450);

            ObservableList<Painting> observableCustomerCart = FXCollections.observableArrayList(customerCart.getAllNodes());
            tableView.setItems(observableCustomerCart);
            tableView.refresh();

            tableView.resizeColumn(NameColumn, 100);
            tableView.resizeColumn(PriceColumn, 50);
            tableView.resizeColumn(ArtistColumn, 150);
            tableView.resizeColumn(YearColumn, 50);

            cartInfo.setVisible(true);
            cartInfo.prefWidth(400);
            cartInfo.prefHeight(50);

            amount.setText(STR."Amount : \{service.GetTotalPrice(customerCart.getAllNodes())}");
        }
    }

    @FXML
    public void onClickBuyButton() {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText("Payment Successful!");
        alert.show();

        customerCart.deleteNodesFromLinkedList();

        ObservableList<Painting> observableCustomerCart = FXCollections.observableArrayList(customerCart.getAllNodes());
        tableView.setItems(observableCustomerCart);
        tableView.refresh();

        amount.setText(STR."Amount : \{service.GetTotalPrice(customerCart.getAllNodes())}");
    }


}