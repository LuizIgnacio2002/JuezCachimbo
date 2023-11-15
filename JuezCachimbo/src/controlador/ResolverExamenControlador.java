/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Pregunta;


public class ResolverExamenControlador implements Initializable {

    @FXML
    private TextArea txtEnunciado;
    @FXML
    private VBox VboxTodasLasPreguntas;
    
    // Almacenar las preguntas en una lista
    ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
    String rutaDelArchivo;
    
private VBox crearVboxPorPregunta(Pregunta pregunta, int numeroPregunta) {
    // Crear un nuevo VBoxPorPregunta
    VBox VboxPorPregunta = new VBox();
    VboxPorPregunta.setPrefHeight(275);
    VboxPorPregunta.setPrefWidth(100);

    // Crear un AnchorPane
    AnchorPane anchorPane = new AnchorPane();
    anchorPane.setPrefHeight(275);
    anchorPane.setPrefWidth(200);

    // Agregar TextField para alternativas
    String[] alternativas = pregunta.getAlternativas().toArray(new String[0]);
    for (int i = 0; i < alternativas.length; i++) {
        TextField textField = new TextField(alternativas[i]);
        textField.setEditable(false);
        textField.setLayoutX(79);
        textField.setLayoutY(46 + i * 39);
        textField.setPrefHeight(31);
        textField.setPrefWidth(734);
        anchorPane.getChildren().add(textField);
    }

    // Agregar RadioButtons
    ToggleGroup toggleGroup = new ToggleGroup();
    char letra = 'A';
    ArrayList<RadioButton> botonesAux = new ArrayList<>();
    for (int i = 0; i < alternativas.length; i++) {
        //Incluir botones al array
        RadioButton radioButton = new RadioButton(letra + ")");
        radioButton.setLayoutX(21);
        radioButton.setLayoutY(51+ i * 39);
        radioButton.setMnemonicParsing(false);
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setId("rdb" + letra + numeroPregunta); // Establecer un ID único
        botonesAux.add(radioButton);
        anchorPane.getChildren().add(radioButton);
        letra++;
    }
    
    pregunta.setBotones(botonesAux);
    
    // Crear Label para la pregunta
    Label label = new Label("Pregunta " + numeroPregunta + ": " + ""+ pregunta.getPregunta());
    label.setFont(new Font("System Bold", 15));
    label.setLayoutX(14);
    label.setLayoutY(-4);
    anchorPane.getChildren().add(label);
    // Agregar AnchorPane al VBoxPorPregunta
    VboxPorPregunta.getChildren().add(anchorPane);

    return VboxPorPregunta;
}

public void initialize(URL url, ResourceBundle rb) {
    try {
        //Ruta del archivo
        rutaDelArchivo = "C:\\Users\\RENZO\\Desktop\\Textos_Grupo1\\2010-I\\2010-I-16-8.txt";
        Intermedia.setRutaDelArchivoAux(rutaDelArchivo);    //Se usa la clase Intermedia de Puente para pasar la ruta
        //Leer el Archivo
        BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String contenidoArchivo = sb.toString();
        br.close();

        // Separamos el contenido en preguntas usando etiqueta "==PREGUNTA=="
        String[] preguntas = contenidoArchivo.split("============PREGUNTA============");

        // Capturamos el enunciado (único)
        String enunciado = preguntas[0];
        Pregunta enunciadoPersona = new Pregunta("============ENUNCIADO============\n" +enunciado);

        // Imprimir el enunciado solo si es diferente de nulo
        if (enunciadoPersona.getEnunciado() != null) {
            System.out.println("ENUNCIADO:");
            System.out.println(enunciadoPersona.getEnunciado());
        }

        for (int i = 1; i < preguntas.length; i++) {
            String preguntaTexto = preguntas[i];
            if (!preguntaTexto.trim().isEmpty()) {
                Pregunta preguntaEjemplo = new Pregunta("============PREGUNTA============" + preguntaTexto);
                listaPreguntas.add(preguntaEjemplo);
            }
        }
        //Estableciendo el enunciado
        txtEnunciado.setText(enunciado);
        
        // Crear el contenedor que contendrá el botón y las preguntas
        VBox contenedorPreguntasYBoton = new VBox();

        // Crear y agregar VBoxPorPregunta para cada pregunta
        for (int i = 0; i < listaPreguntas.size(); i++) {
            VBox VboxPorPregunta = crearVboxPorPregunta(listaPreguntas.get(i), i + 1);
            contenedorPreguntasYBoton.getChildren().add(VboxPorPregunta);
        }

        // Crear el botón y configurar su acción
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(this::enviar);

        // Centrar el botón en el contenedor
        HBox botonesCentrados = new HBox(enviarButton);
        botonesCentrados.setAlignment(Pos.CENTER);
        // Agregar el contenedor con preguntas y el botón a VboxTodasLasPreguntas
        contenedorPreguntasYBoton.getChildren().add(botonesCentrados);
        VboxTodasLasPreguntas.getChildren().add(contenedorPreguntasYBoton);
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            
    }

private void enviar(ActionEvent event) {
    try {
        
        //Captura el radioButton seleccionado y la establece como la clave del usuario
        for(int i=0;i<listaPreguntas.size();i++){
            Pregunta preguntaAux = listaPreguntas.get(i);
            for(int j=0; j<preguntaAux.getBotones().size();j++){
                if(preguntaAux.getBotones().get(j).isSelected()){
                    preguntaAux.setClaveUsuario(j);
                }
            }
        }

        // Guarda una referencia al escenario actual
        Stage escenarioActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        // Cargar Vista Solucionario
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MostrarSolucionario.fxml"));
        // Crear Nodo Interfaz
        Parent root = loader.load();
        
        // Cargando Controlador
        MostrarSolucionarioControlador controlador = loader.getController();
        controlador.setListaAux(listaPreguntas);
        controlador.colocarPreguntas(listaPreguntas);
        System.out.println("PREGUNTAS ENVIADAS");
        

        // Cargando scene y stage
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Juez Cachimbo");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        
        // Cierra la primera vista
        escenarioActual.close();
        
        // Muestra la segunda vista
        stage.showAndWait();
        
        
    } catch (IOException ex) {
        Logger.getLogger(ResolverExamenControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
}
