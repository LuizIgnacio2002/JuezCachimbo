module com.mycompany.cachimboproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cachimboproject to javafx.fxml;
    exports com.mycompany.cachimboproject;
}
