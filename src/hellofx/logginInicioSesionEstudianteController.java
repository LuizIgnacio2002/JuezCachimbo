package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class logginInicioSesionEstudianteController {
    private Stage stage;

    @FXML
    private Button crearCuenta;

    @FXML
    private PasswordField contraseñaPasswordField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    void crearNuevaCuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("estudiante_loggin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        // Obtén el usuario y la contraseña ingresados
        String usuario = usuarioTextField.getText();
        String contraseña = contraseñaPasswordField.getText();

        // Intenta validar el usuario y la contraseña con el archivo usuarios.txt
        boolean usuarioValido = validarUsuario(usuario, contraseña);

        // Muestra una alerta según el resultado
        if (usuarioValido) {
            mostrarAlerta("Inicio de sesión exitoso", "Estudiante válido. Inicio de sesión exitoso.");
        } else {
            mostrarAlerta("Inicio de sesión fallido", "Usuario no registrado o contraseña incorrecta.");
        }
    }

// Método para validar el usuario y la contraseña con el archivo usuarios.txt
private boolean validarUsuario(String usuario, String contraseña) {
    try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/UsuarioInvitado/Desktop/proyectos java/JuezCachimbo/usuarios.txt"))) {
        String username = null;
        String password = null;
        String nombres = null;

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String key = parts[0];
                String value = parts[1];

                if ("Username".equals(key)) {
                    username = value;
                } else if ("Password".equals(key)) {
                    password = value;
                } else if ("Nombres".equals(key)) {
                    nombres = value;
                }

                if (username != null && password != null && nombres != null) {
                    if (usuario.equals(username) && contraseña.equals(password)) {
                        return true;
                    }

                    // Reinicializar las variables para la siguiente entrada
                    username = null;
                    password = null;
                    nombres = null;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return false; // Las credenciales no son válidas o el archivo no pudo leerse
}





    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
