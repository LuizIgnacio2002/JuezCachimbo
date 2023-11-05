package hellofx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class logginInicioSesionProfesorController {
    private Stage stage;

    @FXML
    private Button crearCuenta;

    @FXML
    void crearNuevaCuenta (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profesor_loggin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
