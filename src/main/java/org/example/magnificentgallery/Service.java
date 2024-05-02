package org.example.magnificentgallery;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Service {
    public void displayImagesFromDatabase() {
        // Veritabanına bağlan
        String url = "jdbc:mysql://localhost:3306/art_gallery";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT image FROM artworks";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            JFrame frame = new JFrame("Artworks");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();

            while (resultSet.next()) {
                byte[] imageData = resultSet.getBytes("image");
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
                //mage image = SwingFXUtils.toFXImage(bufferedImage, null);
                //ImageView imageView = new ImageView(image);
                //panel.add(new JLabel(new ImageIcon(image)));
            }

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
