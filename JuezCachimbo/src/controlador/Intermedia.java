package controlador;

import java.util.ArrayList;
import modelo.Pregunta;

public class Intermedia {
    static ArrayList<Pregunta> preguntasAux = new ArrayList<>();

    public static ArrayList<Pregunta> getPreguntasAux() {
        return preguntasAux;
    }

    public static void setPreguntasAux(ArrayList<Pregunta> preguntasAux) {
        Intermedia.preguntasAux = preguntasAux;
    }
    
    
    //Se usa para pasar la ruta desde Resolver Hacia Mostrar
    static String rutaDelArchivoAux;
    public static String getRutaDelArchivoAux() {
        return rutaDelArchivoAux;
    }

    public static void setRutaDelArchivoAux(String rutaDelArchivoAux) {
        Intermedia.rutaDelArchivoAux = rutaDelArchivoAux;
    }
    
    
    
}
