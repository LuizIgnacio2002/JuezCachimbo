package com.mycompany.cachimboproject;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    private Button professorButton;
    private Button studentButton;
    private Stage professorStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Crear las etiquetas "Profesor" y "Alumno"
        Label professorLabel = new Label("Profesor");
        Label studentLabel = new Label("Alumno");

        // Crear botones para cada categoría
        professorButton = new Button("Profesor");
        studentButton = new Button("Alumno");

        // Organizar elementos en un VBox
        VBox professorBox = new VBox(professorLabel, professorButton);
        VBox studentBox = new VBox(studentLabel, studentButton);

        // Centrar el contenido de los VBox
        professorBox.setAlignment(Pos.CENTER);
        studentBox.setAlignment(Pos.CENTER);

        HBox layout = new HBox(professorBox, studentBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 640, 480);

        primaryStage.setTitle("Registro de Profesores y Alumnos");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Configurar el evento del botón "Profesor" para abrir una nueva ventana
        professorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openProfessorWindow();
            }
        });
    }

    // Método para abrir la ventana de registro de profesores
private void openProfessorWindow() {
    if (professorStage == null) {
        try {
            Parent professorRoot = FXMLLoader.load(getClass().getResource("/fxml/professor_registration.fxml"));
            professorStage = new Stage();
            professorStage.setTitle("Registro de Profesor");
            professorStage.setScene(new Scene(professorRoot, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    professorStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
