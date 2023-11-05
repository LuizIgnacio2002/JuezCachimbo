package hellofx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfesorLogginController {

    private Stage stage;

    @FXML
    private Button cuentaCreada;

    @FXML
    void llevarInicioSesion (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loggin_inicio_sesion_estudiante.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
