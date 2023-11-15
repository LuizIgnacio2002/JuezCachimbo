package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.Juez;
import modelo.Pregunta;


public class MostrarSolucionarioControlador implements Initializable {

    @FXML
    private TextArea txtEnunciado;
    @FXML
    private VBox VboxTodasLasPreguntas;
    
    private int puntaje=0;
    
    ArrayList<Pregunta> listaPreguntas = new ArrayList<>();

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }
    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas){
        this.listaPreguntas = listaPreguntas;
    }
   
    private ArrayList<Pregunta> listaAux= new ArrayList<>();

    
    public ArrayList<Pregunta> getListaAux() {
        return listaAux;
    }
    public void setListaAux(ArrayList<Pregunta> listaAux) {
        this.listaAux = listaAux;
    }
    
    private int numDePreguntas=0;
    
private VBox crearVboxPorPregunta(Pregunta pregunta, int numeroPregunta) {
    // Crear un nuevo VBoxPorPregunta
    System.out.println(pregunta.getClaveUsuario());
    VBox vboxPorPregunta = new VBox();
    vboxPorPregunta.setPrefHeight(335);
    vboxPorPregunta.setPrefWidth(920);

    // Crear un AnchorPane
    AnchorPane anchorPane = new AnchorPane();
    anchorPane.setPrefHeight(335);
    anchorPane.setPrefWidth(920);

    // Agregar Label para la pregunta
    Label lblPregunta = new Label("Pregunta " + numeroPregunta + ": " + pregunta.getPregunta());
    lblPregunta.setFont(new Font("System Bold", 15));
    lblPregunta.setLayoutX(14);
    lblPregunta.setLayoutY(-19);

    // Agregar TextFields para las 5 alternativas
    String[] alternativas = pregunta.getAlternativas().toArray(new String[0]);
    char letra = 'A';
    ToggleGroup toggleGroup = new ToggleGroup();
    for (int i = 0; i < Math.min(5, alternativas.length); i++) {
        RadioButton radioButton = new RadioButton(letra + ")");
        radioButton.setLayoutX(21);
        radioButton.setLayoutY(30 + i * 39);
        radioButton.setMnemonicParsing(false);
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setDisable(true); // Deshabilitar los RadioButtons
        radioButton.setId("rdb" + letra + numeroPregunta); // Establecer un ID único

        if(pregunta.getClaveUsuario() == (i)){
            radioButton.setStyle("-fx-background-color:yellow;");
        }
        
        anchorPane.getChildren().add(radioButton);
        TextField textField = new TextField(alternativas[i]);
        textField.setPrefHeight(31);
        textField.setPrefWidth(734);
        textField.setLayoutX(80);
        textField.setLayoutY(30 + i * 39);
        textField.setEditable(false);
        textField.setId("txt" + letra + numeroPregunta); // Establecer un ID único
        anchorPane.getChildren().add(textField);
        letra++;
    }

    // Agregar Label para el razonamiento
    Label lblRazonamiento = new Label("Razonamiento: ");
    lblRazonamiento.setFont(new Font("System Bold", 15));
    lblRazonamiento.setLayoutX(22);
    lblRazonamiento.setLayoutY(245);

    // Agregar un TextArea adaptable para el razonamiento
    TextArea txtRazonamiento = new TextArea(pregunta.getRazonamiento());
    txtRazonamiento.setPrefHeight(50);
    txtRazonamiento.setPrefWidth(734);
    txtRazonamiento.setLayoutX(141);
    txtRazonamiento.setLayoutY(230);
    txtRazonamiento.setEditable(false);
    txtRazonamiento.setId("txtRazonamiento" + numeroPregunta); // Establecer un ID único
    txtRazonamiento.setWrapText(true); // Permitir el ajuste del texto

    // Agregar todos los elementos al AnchorPane
    anchorPane.getChildren().addAll(lblPregunta, lblRazonamiento, txtRazonamiento);

    // Agregar el AnchorPane al VBox
    vboxPorPregunta.getChildren().add(anchorPane);

    return vboxPorPregunta;
}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    
        try {            
            BufferedReader br = new BufferedReader(new FileReader(Intermedia.getRutaDelArchivoAux()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String contenidoArchivo = sb.toString();
            br.close();

            // Separar el contenido en preguntas usando "==PREGUNTA=="
            String[] preguntas = contenidoArchivo.split("============PREGUNTA============");

            // Capturar el enunciado (único)
            String enunciado = preguntas[0];
            Pregunta enunciadoPersona = new Pregunta("============ENUNCIADO============\n" +enunciado);

            // Imprimir el enunciado solo si no es nulo
            if (enunciadoPersona.getEnunciado() != null) {
                System.out.println("ENUNCIADO:");
                System.out.println(enunciadoPersona.getEnunciado());
            }
  
            //Estableciendo el enunciado
            txtEnunciado.setText(enunciado);

            System.out.println(enunciado);
          
       
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    


public void colocarPreguntas(ArrayList<Pregunta> listaPreguntasAux){
        Juez juez = new Juez();
    for (int i = 0; i < listaPreguntasAux.size(); i++) {
            VBox VboxPorPregunta = crearVboxPorPregunta(listaPreguntasAux.get(i), i + 1);
            VboxTodasLasPreguntas.getChildren().add(VboxPorPregunta);
            Pregunta pregunta = listaPreguntasAux.get(i);
            
            //Juez
            numDePreguntas++;
            juez.setNumeroDePreguntas(numDePreguntas);
            char[] letra = pregunta.getClaveCorrecta().toCharArray();
            int claveCorrecta = (int)letra[0] - 65;
            
            if(pregunta.getClaveUsuario() == -1){
               juez.actualizarContadorRespuestasBlancas();
            }else if(claveCorrecta == pregunta.getClaveUsuario()){
                juez.actualizarContadorRespuestasCorrectas();
            }
            else{
                juez.actualizarContadorRespuestasIncorrectas();
            }
            
            /*
            if(claveCorrecta == pregunta.getClaveUsuario()){
                juezCachimbo.actualizarContadorRespuestasCorrectas();
            }*/
            
        }
        
    //VERIFICANDO EN CONSOLA
    System.out.println("Número de Preguntas: " + juez.getNumeroDePreguntas());
    System.out.println("Preguntas Correctas: " + juez.getContadorRespuestasCorrectas());
    System.out.println("Preguntas Incorrectas: " + juez.getContadorRespuestasIncorrectas());
    System.out.println("Preguntas en Blanco: " + juez.getContadorRespuestasBlancas());
}

}
