package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class SeleccionarRolController {

    private Stage stage;
    @FXML
    private Button professorButton;

    @FXML
    private Button studentButton; // Inyecta el botón en el controlador

    @FXML
    void switchToEstudianteLoggin(ActionEvent event) throws IOException {
        // Accede al botón studentButton y realiza alguna acción si es necesario
        if (studentButton != null) {
            // Hacer algo con el botón (por ejemplo, cambiar su texto)
            studentButton.setText("Estudiante Button Clicked");
        }

        // Resto del código para cambiar a la vista de estudiante_loggin.fxml
        Parent root = FXMLLoader.load(getClass().getResource("loggin_inicio_sesion_estudiante.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
void switchToProfesorLoggin(ActionEvent event) throws IOException {
    // Accede al botón professorButton y realiza alguna acción si es necesario
    if (professorButton != null) {
        // Hacer algo con el botón (por ejemplo, cambiar su texto)
        professorButton.setText("Profesor Button Clicked");
    }

    // Resto del código para cambiar a la vista de profesor_loggin.fxml (ajusta el nombre del archivo según sea necesario)
    Parent root = FXMLLoader.load(getClass().getResource("loggin_inicio_sesion_profesor.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

}
