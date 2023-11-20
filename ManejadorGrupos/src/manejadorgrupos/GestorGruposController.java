package manejadorgrupos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
// import org.controlsfx.control.textfield.TextFields;
import javafx.scene.layout.AnchorPane;
import manejadorgrupos.grupos.GestorGrupos;
import manejadorgrupos.usuario_modelo_simple.Alumno;

public class GestorGruposController {

    private final GestorGrupos gestorGrupos = new GestorGrupos();

    @FXML
    private TextField nombreGrupoTextField;
    
    @FXML
    private ChoiceBox<String> profesoresChoiceBox;

    @FXML
    private TextField idProfesorTextField;

    @FXML
    private ChoiceBox<String> gruposChoiceBox;

    @FXML
    private TextField nombreAlumnoTextField; 
    
    @FXML
    private AnchorPane anchorPaneCrearGrupo;
    
    @FXML
    private AnchorPane anchorPaneAgregarAlumno;
    
    @FXML
    private AnchorPane anchorPaneVerAvance;
    
    @FXML
    private Button crearGrupoButton;
    
    @FXML
    private Button agregarAlumnoButton;
    
    @FXML
    private Button verAvanceButton;
    
    @FXML
    private TabPane tabPane;
    
    
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
        HashMap<Integer, String> profesoresIdNombre = obtenerProfesoresIdNombre();
        profesoresChoiceBox.setItems(FXCollections.observableArrayList(profesoresIdNombre.values()));
        
        System.out.println("refreshCrearGrupoTab");
    }
    
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
        gruposChoiceBox.setItems(FXCollections.observableArrayList(gruposIdNombre.values()));
        
        // TextFields.bindAutoCompletion(nombreAlumnoTextField, listaAlumnosSimulacion());
        
        System.out.println("refreshAgregarAlumnoTab");
    }
    
    private void initializeVerAvance() {
        
        System.out.println("initializeVerAvance");
        refreshVerAvance();
        
        // centrar elementos en el tab crear grupo
        anchorPaneVerAvance.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) { 
                
                // Accedemos a la escena desde el AnchorPane
                Scene scene = anchorPaneVerAvance.getScene();
                
                scene.widthProperty().addListener((obs, oldWidth, newWidth) -> { 
                    AnchorPane.setLeftAnchor(verAvanceButton, (scene.getWidth() - verAvanceButton.getWidth()) / 2); 
                });

                scene.heightProperty().addListener((obs, oldHeight, newHeight) -> { 
                    AnchorPane.setTopAnchor(verAvanceButton, (scene.getHeight() - verAvanceButton.getHeight()) / 2);
                });
            }
        });
    }
    
    private void refreshVerAvance() {
        // code refresh for this tab
        System.out.println("refreshVerAvance");
    }

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
            profesoresChoiceBox.setValue(null);
            
            
            HashMap<Integer, String> gruposIdNombre = gestorGrupos.obtenerGruposIdNombre();
            gruposChoiceBox.setItems(FXCollections.observableArrayList(gruposIdNombre.values()));
        } 
    }
    
    private HashMap<Integer, String> obtenerProfesoresIdNombre() {
        // Simulación de obtener profesores de tu HashMap  
        HashMap<Integer, String> profesores = new HashMap<>();
        profesores.put(1, "Profesor1");
        profesores.put(2, "Profesor2");
        profesores.put(3, "Profesor3");
        return profesores;
    }
    
    private int obtenerIdProfesorSeleccionado() {
        // Obtener el nombre del profesor seleccionado en el ChoiceBox
        String nombreProfesor = profesoresChoiceBox.getValue();
        // Simulación inversa: encontrar el ID del profesor a partir de su nombre  
        HashMap<Integer, String> profesores = obtenerProfesoresIdNombre();
        for (HashMap.Entry<Integer, String> entry : profesores.entrySet()) {
            if (entry.getValue().equals(nombreProfesor)) {
                return entry.getKey();
            }
        }
        return 0; // Valor predeterminado o manejo de error
    }

    @FXML
    private void agregarAlumnoAGrupo() {
        // Lógica para agregar un alumno al grupo seleccionado
        String nombreAlumno = nombreAlumnoTextField.getText();
        nombreAlumnoTextField.clear();
        
        Alumno alumno = obtenerAlumnoPorNombre(nombreAlumno);
        
        if (alumno != null) {
            nombreAlumnoTextField.setStyle(null);
            int codigoGrupo = obtenerCodigoGrupoSeleccionado();
            alumno.setCodigoGrupo(codigoGrupo);
            
            gestorGrupos.obtenerGrupoPorCodigo(codigoGrupo).aniadirAlumnosPorCodigo(alumno.getCodigo());
            
            System.out.println(alumno.getNombre() + " -> Grupo [" + gestorGrupos.obtenerGrupoPorCodigo(codigoGrupo).getNombre() + "]");
        } else {
            nombreAlumnoTextField.setStyle("-fx-border-color: red;");
            System.out.println("No se pudo añadir.");
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
    
    private int obtenerCodigoGrupoSeleccionado() {
        // Lógica para obtener el código del grupo seleccionado en el ChoiceBox
        String grupoSeleccionado = gruposChoiceBox.getValue();
        // Puedes implementar lógica para convertir el nombre del grupo en su código correspondiente
        return gestorGrupos.obtenerCodigoPorNombre(grupoSeleccionado);
    }
    
    //-- --------------------------------------------

    @FXML
    private void obtenerAvance() {
        // Lógica para obtener el avance del grupo seleccionado
        int codigoGrupo = obtenerCodigoGrupoSeleccionado();
        String avance = gestorGrupos.obtenerAvance(codigoGrupo);
        System.out.println(avance);
    }
}
