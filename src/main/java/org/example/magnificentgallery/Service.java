package org.example.magnificentgallery;

import javafx.collections.ObservableArray;
import org.example.magnificentgallery.Entity.Cart;
import org.example.magnificentgallery.Entity.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;

public class Service {
    public void displayImagesFromDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection dbConnection = DriverManager.getConnection( "jdbc:oracle:thin:@193.255.85.26:1521/orcl", "STU2202095", "STU2202095");
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from [User]");
             while(resultSet.next())
            {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),

                        resultSet.getString("lastName"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getDouble("loan"),

                        resultSet.getString("address"),
                        resultSet.getString("email")
                );
            }
            dbConnection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User GetUser(String Email) {
        // Veritabanına bağlan
        String url = "jdbc:oracle:thin:@//193.255.85.26:1521/xe";
        String username = "STU2202095";
        String password = "STU2202095";

        try{
            String sql = "SELECT * FROM User where Email='ozge.odabas@bahcesehir.edu.tr'";

            if (true) {
                User newUser = new User() {
                    {
                        setId(1); // ID değerini burada belirtin
                        setFirstName("Ozge");
                        setLastName("Odabas");
                        setEmail("ozge.odabas@bahcesehir.edu.tr");
                        // Diğer alanları da isteğinize göre burada belirtebilirsiniz
                    }
                };
                return newUser;
            } else {
                return null; // Sonuç kümesi boşsa null döndür
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Cart> GetCart() {
        // Veritabanına bağlan
        String url = "jdbc:oracle:thin:@//193.255.85.26:1521/xe";
        String username = "STU2202095";
        String password = "STU2202095";

        try{
            String sql = "SELECT * FROM Cart where UserId= userId";
            ArrayList<Cart> cart = new ArrayList<Cart>();
            cart.add(new Cart(1,1,1,1,100,"ozge","odabas","url"));

            cart.add(new Cart(2,2,2,2,140,"ozge","odabas","url2"));
            return cart;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<Cart>();
    }

    public double GetTotalPrice(int userId) {
        // Veritabanına bağlan
        String url = "jdbc:oracle:thin:@//193.255.85.26:1521/xe";
        String username = "STU2202095";
        String password = "STU2202095";
        double totalAmount = 0;

        try{
            String sql = "SELECT * FROM Cart where UserId= userId";
            ArrayList<Cart> cart = new ArrayList<Cart>();
            cart.add(new Cart(1,1,1,1,100,"ozge","odabas","url"));

            cart.add(new Cart(2,2,2,2,140,"ozge","odabas","url2"));

            if (cart != null || !cart.isEmpty()) {
                totalAmount = cart.stream().mapToDouble(x -> x.getPrice()).sum();
                return totalAmount;
            }
            else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
