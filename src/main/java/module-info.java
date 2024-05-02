module org.example.magnificentgallery {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens org.example.magnificentgallery to javafx.fxml;
    exports org.example.magnificentgallery;
}