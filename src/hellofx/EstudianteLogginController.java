package hellofx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.EOFException;

public class EstudianteLogginController {

    private Stage stage;

    @FXML
    private Button cuentaCreada;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField nombresField;

    @FXML
    private TextField apellidosField;

    @FXML
    private DatePicker fechaNacimientoPicker;

    @FXML
    public void nuevaCuenta(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String nombres = nombresField.getText();
        String apellidos = apellidosField.getText();
        String fechaNacimiento = fechaNacimientoPicker.getValue().toString();

        // Crear una instancia de Usuario
        Usuario usuario = new Usuario(username, password, nombres);

        // Serializar y guardar en un archivo de texto en formato UTF-8
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usuarios.txt", true)))) {
            // Escribe los datos del usuario en UTF-8
            writer.println(usuario.toUTF8String());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @FXML
    void llevarInicioSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loggin_inicio_sesion_estudiante.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
