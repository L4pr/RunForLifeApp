module org.example.runforlife_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.runforlife_app to javafx.fxml;
    opens org.example.runforlife_app.Administratie to javafx.fxml;
    exports org.example.runforlife_app.util;
    opens org.example.runforlife_app.util to javafx.fxml;
    exports org.example.runforlife_app.Administratie;
    exports org.example.runforlife_app;
}