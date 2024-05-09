module org.example.magnificentgallery {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;
    requires com.oracle.database.jdbc;

    opens org.example.magnificentgallery to javafx.fxml;
    exports org.example.magnificentgallery;
    exports org.example.magnificentgallery.Entity;
    opens org.example.magnificentgallery.Entity to javafx.fxml;
}