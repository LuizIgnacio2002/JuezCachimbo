package manejadorgrupos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
// import org.controlsfx.control.textfield.TextFields;
import javafx.scene.layout.AnchorPane;
import manejadorgrupos.grupos.GestorGrupos;
import manejadorgrupos.usuario_modelo_simple.Alumno;

public class GestorGruposController {

    private final GestorGrupos gestorGrupos = new GestorGrupos();

    // tab -> Crear grupo
    @FXML
    private AnchorPane anchorPaneCrearGrupo;
    @FXML
    private TextField nombreGrupoTextField;
    @FXML
    private ChoiceBox<String> profesoresChoiceBox;
    @FXML
    private Button crearGrupoButton;
    
    private void initializeCrearGrupoTab() { 
        
        System.out.println("initializeCrearGrupoTab");
        refreshCrearGrupoTab();
        
        // centrar elementos en el tab crear grupo
        anchorPaneCrearGrupo.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                double yOffset;
                yOffset = 40.0d;
                
                // Accedemos a la escena desde el AnchorPane
                Scene scene = anchorPaneCrearGrupo.getScene();
                
                scene.widthProperty().addListener((obs, oldWidth, newWidth) -> {
                    AnchorPane.setLeftAnchor(nombreGrupoTextField, (scene.getWidth() - nombreGrupoTextField.getWidth()) / 2);
                    AnchorPane.setLeftAnchor(profesoresChoiceBox, (scene.getWidth() - profesoresChoiceBox.getWidth()) / 2);
                    AnchorPane.setLeftAnchor(crearGrupoButton, (scene.getWidth() - crearGrupoButton.getWidth()) / 2);
                    System.out.println("getwidth: " + crearGrupoButton.getWidth());
                });

                scene.heightProperty().addListener((obs, oldHeight, newHeight) -> {
                    AnchorPane.setTopAnchor(nombreGrupoTextField, (scene.getHeight() - nombreGrupoTextField.getHeight()) / 2 - yOffset);
                    AnchorPane.setTopAnchor(profesoresChoiceBox, (scene.getHeight() - profesoresChoiceBox.getHeight()) / 2);
                    AnchorPane.setTopAnchor(crearGrupoButton, (scene.getHeight() - crearGrupoButton.getHeight()) / 2 + yOffset);
                });
            }
        });
    }
    
    private void refreshCrearGrupoTab() {
        // Obtener los nombres de los profesores del HashMap y agregarlos al ChoiceBox
        Map<Integer, String> profesoresIdNombre = obtenerProfesoresIdNombre();
        profesoresIdNombre.put(0, "no-profesor");
        profesoresChoiceBox.setItems(FXCollections.observableArrayList(profesoresIdNombre.values()));
        profesoresChoiceBox.setValue("no-profesor");
        
        System.out.println("refreshCrearGrupoTab");
    }
    
    @FXML
    private void crearGrupo() {
        // Lógica para crear un grupo con los datos ingresados por el usuario
        
        boolean tenemos_los_datos = true;
        
        String nombreGrupo = nombreGrupoTextField.getText();
        if (nombreGrupo.isEmpty()) {
            tenemos_los_datos = false;
            nombreGrupoTextField.setStyle("-fx-border-color: red;");
            System.out.println("Error: no ingresó el nombre.");
        }
        
        int idProfesor = obtenerIdProfesorSeleccionado();
        if (idProfesor == 0) {
            tenemos_los_datos = false;
            profesoresChoiceBox.setStyle("-fx-border-color: red;");
            System.out.println("Error: no seleccionó a un profesor.");
        }
        
        if (tenemos_los_datos) {
            gestorGrupos.crearGrupo(nombreGrupo, idProfesor);
            nombreGrupoTextField.setStyle(null);
            profesoresChoiceBox.setStyle(null);
            System.out.println(gestorGrupos.obtenerInfoTodosGrupos());
            
            nombreGrupoTextField.clear();
            profesoresChoiceBox.setValue("no-profesor");
            
            HashMap<Integer, String> gruposIdNombre = gestorGrupos.obtenerGruposIdNombre();
            gruposChoiceBox.setItems(FXCollections.observableArrayList(gruposIdNombre.values()));
        } 
    }
    
    private Map<Integer, String> obtenerProfesoresIdNombre() {
        // Simulación de obtener profesores de tu HashMap  
        Map<Integer, String> profesores = new HashMap<>();
        profesores.put(1, "Ana");
        profesores.put(2, "Carlos");
        profesores.put(3, "Elena");
        profesores.put(4, "David");
        profesores.put(5, "Isabel");
        profesores.put(6, "Juan");
        profesores.put(7, "Laura");
        profesores.put(8, "Miguel");
        profesores.put(9, "Patricia");
        profesores.put(10, "Roberto");
        return profesores;
    }
    
    private int obtenerIdProfesorSeleccionado() {
        // Obtener el nombre del profesor seleccionado en el ChoiceBox
        String nombreProfesor = profesoresChoiceBox.getValue();
        // Simulación inversa: encontrar el ID del profesor a partir de su nombre  
        Map<Integer, String> profesores = obtenerProfesoresIdNombre();
        for (Map.Entry<Integer, String> entry : profesores.entrySet()) {
            if (entry.getValue().equals(nombreProfesor)) {
                return entry.getKey();
            }
        }
        return 0; // Valor predeterminado o manejo de error
    }
    // -------------------------------------------------------------------------------------------
    
    // tab -> Agregar Alumno a Grupo
    @FXML
    private AnchorPane anchorPaneAgregarAlumno;
    @FXML
    private ChoiceBox<String> gruposChoiceBox;
    @FXML
    private TextField nombreAlumnoTextField; 
    @FXML
    private Button agregarAlumnoButton;

    private void initializeAgregarAlumnoTab() {

        System.out.println("initializeAgregarAlumnoTab");
        refreshAgregarAlumnoTab();
        
        // centrar elementos en el tab crear grupo
        anchorPaneAgregarAlumno.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                double yOffset;
                yOffset = 40.0d;
                
                // Accedemos a la escena desde el AnchorPane
                Scene scene = anchorPaneAgregarAlumno.getScene();
                
                scene.widthProperty().addListener((obs, oldWidth, newWidth) -> {
                    AnchorPane.setLeftAnchor(nombreAlumnoTextField, (scene.getWidth() - nombreAlumnoTextField.getWidth()) / 2);
                    AnchorPane.setLeftAnchor(gruposChoiceBox, (scene.getWidth() - gruposChoiceBox.getWidth()) / 2);
                    AnchorPane.setLeftAnchor(agregarAlumnoButton, (scene.getWidth() - agregarAlumnoButton.getWidth()) / 2);
                });

                scene.heightProperty().addListener((obs, oldHeight, newHeight) -> {
                    AnchorPane.setTopAnchor(nombreAlumnoTextField, (scene.getHeight() - nombreAlumnoTextField.getHeight()) / 2 - yOffset);
                    AnchorPane.setTopAnchor(gruposChoiceBox, (scene.getHeight() - gruposChoiceBox.getHeight()) / 2);
                    AnchorPane.setTopAnchor(agregarAlumnoButton, (scene.getHeight() - agregarAlumnoButton.getHeight()) / 2 + yOffset);
                });
            }
        });
    }
    
    private void refreshAgregarAlumnoTab() {
        
        // Obtener el id y nombre de los grupos
        HashMap<Integer, String> gruposIdNombre = gestorGrupos.obtenerGruposIdNombre();
        gruposIdNombre.put(0, "no-grupo");
        gruposChoiceBox.setItems(FXCollections.observableArrayList(gruposIdNombre.values()));
        gruposChoiceBox.setValue("no-grupo");
        // TextFields.bindAutoCompletion(nombreAlumnoTextField, listaAlumnosSimulacion());
        
        System.out.println("refreshAgregarAlumnoTab");
    }

    @FXML
    private void agregarAlumnoAGrupo() {
        // Lógica para agregar un alumno al grupo seleccionado
        String nombreAlumno = nombreAlumnoTextField.getText();
        
        Alumno alumno = obtenerAlumnoPorNombre(nombreAlumno);
        
        boolean tenemos_los_datos = true;
        
        if (alumno != null) {
            nombreAlumnoTextField.setStyle(null);
        } else {
            nombreAlumnoTextField.clear();
            tenemos_los_datos = false;
            nombreAlumnoTextField.setStyle("-fx-border-color: red;");
            System.out.println("No se encuentra al alumno.");
        }
        
        int codigoGrupo = obtenerCodigoGrupoSeleccionado(gruposChoiceBox);
        if (codigoGrupo != 0) {
            gruposChoiceBox.setStyle(null);
            System.out.println(alumno.getNombre() + " -> Grupo [" + gestorGrupos.obtenerGrupoPorCodigo(codigoGrupo).getNombre() + "]");
        } else {
            tenemos_los_datos = false;
            gruposChoiceBox.setStyle("-fx-border-color: red;");
        }
        
        if (tenemos_los_datos) {
            nombreAlumnoTextField.clear();
            gruposChoiceBox.setValue("no-grupo");
            alumno.setCodigoGrupo(codigoGrupo);
            gestorGrupos.obtenerGrupoPorCodigo(codigoGrupo).aniadirAlumnosPorCodigo(alumno.getCodigo());
        }
    }

    // metodos momentaneos
    private HashMap<Integer, Alumno> obtenerAlumnoSimulacionDeDatos() {
        HashMap<Integer, Alumno> alumnos = new HashMap<>();

        String[] nombres = {"Alejandro", "Isabella", "Mateo", "Olivia", "Sebastián", "Valentina", "Diego", "Camila", "Gabriel", "Sofía"};

        for (int i = 1; i <= nombres.length; i++) {
            Alumno alumno = new Alumno(nombres[i - 1]);
            alumno.setCodigoGrupo(1); // Código de grupo simulado
            alumnos.put(i, alumno);
        }

        return alumnos;
    }

    private List<String> listaAlumnosSimulacion() {
        
        List<String> nombreAlumnos = new ArrayList<>();
        
        for (HashMap.Entry<Integer, Alumno> entry: obtenerAlumnoSimulacionDeDatos().entrySet()) {
            nombreAlumnos.add(entry.getValue().getNombre());
        }
        
        return nombreAlumnos;
    }
    
    private Alumno obtenerAlumnoPorNombre(String nombreAlumno) { 
        for (HashMap.Entry<Integer, Alumno> entry: obtenerAlumnoSimulacionDeDatos().entrySet()) {
            if (entry.getValue().getNombre().equals(nombreAlumno)) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    private int obtenerCodigoGrupoSeleccionado(ChoiceBox choice) {
        // Lógica para obtener el código del grupo seleccionado en el ChoiceBox
        String grupoSeleccionado = (String) choice.getValue();
        
        // Lógica para convertir el nombre del grupo en su código correspondiente
        return gestorGrupos.obtenerCodigoPorNombre(grupoSeleccionado);
    }
    // -------------------------------------------------------------------------------------------
    
    // tab -> Ver Avance
    @FXML
    private AnchorPane anchorPaneVerAvance;
    @FXML
    private Button verAvanceButton;
    @FXML
    private ChoiceBox gruposParaVerAvanceChoiceBox;
    @FXML
    private ScrollPane rectanguloMostrarInfo;     
    @FXML
    private Label rectanguloMostrarInfoLabel; 
    
    private void initializeVerAvance() {
        
        var espacio_entre_elementos = 40d;
        
        System.out.println("initializeVerAvance");
        refreshVerAvance();
        
        // centrar elementos en el tab crear grupo
        anchorPaneVerAvance.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) { 
                // Accedemos a la escena desde el AnchorPane
                Scene scene = anchorPaneVerAvance.getScene();
                
                scene.widthProperty().addListener((obs, oldWidth, newWidth) -> { 
                    rectanguloMostrarInfo.setPrefWidth(scene.getWidth() - 2 * espacio_entre_elementos);                    
                    rectanguloMostrarInfoLabel.setPrefWidth(scene.getWidth() - 2 * espacio_entre_elementos);
                    AnchorPane.setLeftAnchor(gruposParaVerAvanceChoiceBox, (scene.getWidth() - espacio_entre_elementos) / 2 - gruposParaVerAvanceChoiceBox.getWidth());
                    AnchorPane.setLeftAnchor(verAvanceButton, (scene.getWidth() + espacio_entre_elementos) / 2);
                    AnchorPane.setLeftAnchor(rectanguloMostrarInfo, espacio_entre_elementos);
                });
                
                scene.heightProperty().addListener((obs, oldHeight, newHeight) -> { 
                    rectanguloMostrarInfo.setPrefHeight(scene.getHeight() / 2 - 2 * espacio_entre_elementos);
                    AnchorPane.setTopAnchor(gruposParaVerAvanceChoiceBox, (scene.getHeight() / 2 - espacio_entre_elementos) / 2 - gruposParaVerAvanceChoiceBox.getHeight());
                    AnchorPane.setTopAnchor(verAvanceButton, (scene.getHeight() / 2 - espacio_entre_elementos) / 2 - verAvanceButton.getHeight());
                    AnchorPane.setTopAnchor(rectanguloMostrarInfo, scene.getHeight() / 2 + espacio_entre_elementos);
                });
            }
        });
    }
    
    private void refreshVerAvance() {
        // code refresh for this tab
        System.out.println("refreshVerAvance");
        rectanguloMostrarInfo.setStyle("-fx-border-color: darkblue; -fx-background-color: lightblue;");
        rectanguloMostrarInfoLabel.setStyle("-fx-background-color: lightblue;");
        rectanguloMostrarInfoLabel.setText("\n\t\t\tShow info.");
        
        HashMap<Integer, String> gruposIdNombre = gestorGrupos.obtenerGruposIdNombre();
        
        if (gestorGrupos.obtenerCantidadGrupos() >= 2) {
            gruposIdNombre.put(-1, "Todos");
        } else if (gestorGrupos.obtenerCantidadGrupos() == 0) {
            gruposIdNombre.put(0, "no-grupos");
            System.out.println(gestorGrupos.obtenerCantidadGrupos());
        }
        
        gruposParaVerAvanceChoiceBox.setItems(FXCollections.observableArrayList(gruposIdNombre.values()));
    
        if (gestorGrupos.obtenerCantidadGrupos() >= 2) { 
            gruposParaVerAvanceChoiceBox.setValue("Todos");
        } else if (gestorGrupos.obtenerCantidadGrupos() == 0) {
            gruposParaVerAvanceChoiceBox.setValue("no-grupos");
        }
    }

    @FXML
    private void obtenerAvance() {
        
        String styleForRectanguleTextBorder = "-fx-border-color: darkgreen;";
        String styleForRectanguleTextBackground = "-fx-background-color: lightgreen;";
        String msgForShow = "\n\t\t\tEstadistica grupos\n";
        
        String nameGroupSelected = (String) gruposParaVerAvanceChoiceBox.getValue();
        
        switch (nameGroupSelected) {
            case "Todos" -> msgForShow += gestorGrupos.obtenerAvanceTodoGrupos();
            case "no-grupos" -> {
                msgForShow = "\n\t\t\tNo hay grupos.";
                styleForRectanguleTextBorder = "-fx-border-color: darkred;";
                styleForRectanguleTextBackground = "-fx-background-color: red;";
            }
            default -> msgForShow += gestorGrupos.obtenerAvance(obtenerCodigoGrupoSeleccionado(gruposParaVerAvanceChoiceBox));
        }
        
        rectanguloMostrarInfoLabel.setText(msgForShow);
        rectanguloMostrarInfo.setStyle(styleForRectanguleTextBorder + " " + styleForRectanguleTextBackground);        
        rectanguloMostrarInfoLabel.setStyle(styleForRectanguleTextBackground);

    }
    // -------------------------------------------------------------------------------------------
    
    // init 
    @FXML
    private TabPane tabPane;
    
    @FXML
    private void initialize() {
        initializeAgregarAlumnoTab();
        initializeCrearGrupoTab();
        initializeVerAvance();
                
        // Configurar un controlador para el cambio de pestaña
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                // Realizar acciones específicas según la pestaña seleccionada
                String tabText = newTab.getText();
                
                // Llamar a métodos específicos para cada pestaña
                switch (tabText) {
                    case "Crear Grupo" -> {
                        refreshCrearGrupoTab();
                    }
                    case "Agregar Alumno a Grupo" -> {
                        refreshAgregarAlumnoTab();
                    }
                    case "Ver Avance" -> {
                        refreshVerAvance();
                    }
                    default -> {
                    }
                }
            }
        });
    }
    // -----------------------------------------------------------------------------------------------------
}
