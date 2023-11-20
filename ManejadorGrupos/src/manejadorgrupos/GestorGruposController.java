package manejadorgrupos;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import manejadorgrupos.grupos.GestorGrupos;
import manejadorgrupos.usuario_modelo_simple.Alumno;

public class GestorGruposController {

    private final GestorGrupos gestorGrupos = new GestorGrupos();

    @FXML
    private TextField nombreGrupoTextField;

    @FXML
    private TextField idProfesorTextField;

    @FXML
    private ChoiceBox<String> gruposChoiceBox;

    @FXML
    private TextField nombreAlumnoTextField;

    @FXML
    private void initialize() {
        // Inicializar el ChoiceBox con los nombres de los grupos existentes
        gruposChoiceBox.setItems(FXCollections.observableArrayList("Grupo1", "Grupo2", "Grupo3"));
    }

    @FXML
    private void crearGrupo() {
        // Lógica para crear un grupo con los datos ingresados por el usuario
        String nombreGrupo = nombreGrupoTextField.getText();
        int idProfesor = Integer.parseInt(idProfesorTextField.getText());
        // Obtener código único para el grupo (puedes implementar lógica para generar códigos únicos)
        int codigo = gestorGrupos.obtenerCodigoUnico();
        gestorGrupos.crearGrupo(codigo, nombreGrupo, idProfesor);
    }

    @FXML
    private void agregarAlumno() {
        // Lógica para agregar un alumno al grupo seleccionado
        String nombreAlumno = nombreAlumnoTextField.getText();
        int codigoGrupo = obtenerCodigoGrupoSeleccionado();
        gestorGrupos.agregarAlumnoAlGrupo(codigoGrupo, new Alumno(nombreAlumno));
    }

    @FXML
    private void obtenerAvance() {
        // Lógica para obtener el avance del grupo seleccionado
        int codigoGrupo = obtenerCodigoGrupoSeleccionado();
        String avance = gestorGrupos.obtenerAvance(codigoGrupo);
        System.out.println(avance);
    }

    private int obtenerCodigoGrupoSeleccionado() {
        // Lógica para obtener el código del grupo seleccionado en el ChoiceBox
        String grupoSeleccionado = gruposChoiceBox.getValue();
        // Puedes implementar lógica para convertir el nombre del grupo en su código correspondiente
        return gestorGrupos.obtenerCodigoPorNombre(grupoSeleccionado);
    }
}
