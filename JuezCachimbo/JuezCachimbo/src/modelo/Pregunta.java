package modelo;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.RadioButton;

public class Pregunta {
    private String enunciado;
    private String pregunta;
    private ArrayList<String> alternativas;
    private ArrayList<RadioButton> botones;
    //Clave Seleccionada int=--1
    private int claveCorrectaEntero;
    private int claveUsuario = -1;
    private String claveCorrecta;
    private String razonamiento;

    public Pregunta(String texto) {
        Pattern pattern = Pattern.compile("============([^=]+)============\\n([^=]+)");
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            String etiqueta = matcher.group(1);
            String contenido = matcher.group(2);

            switch (etiqueta) {
                case "ENUNCIADO":
                    enunciado = contenido;
                    break;
                case "PREGUNTA":
                    pregunta = contenido;
                    break;
                case "ALTERNATIVAS":
                    alternativas = new ArrayList<>();
                    String[] lineasAlternativas = contenido.split("\\n");
                    for (int i = 0; i < lineasAlternativas.length; i++) {
                        alternativas.add(lineasAlternativas[i]);
                    }
                    break;
                case "CORRECTA":
                    claveCorrecta = contenido;
                    break;
                case "RAZONAMIENTO":
                    razonamiento = contenido;
                    break;
            }
        }
    }

    public int getClaveCorrectaEntero() {
        return claveCorrectaEntero;
    }

    public void setClaveCorrectaEntero(int claveCorrectaEntero) {
        this.claveCorrectaEntero = claveCorrectaEntero;
    }

    public int getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(int claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    
    
    
    public String getEnunciado() {
        return enunciado;
    }

    public String getPregunta() {
        return pregunta;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public String getClaveCorrecta() {
        return claveCorrecta;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public ArrayList<RadioButton> getBotones() {
        return botones;
    }

    public void setBotones(ArrayList<RadioButton> botones) {
        this.botones = botones;
    }

    
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        if (enunciado != null) {
            result.append("").append(enunciado).append("\n");
        }
        if (pregunta != null) {
            result.append("PREGUNTA: ").append(pregunta).append("\n");
        }
        if (alternativas != null) {
            result.append("ALTERNATIVAS: ").append(alternativas).append("\n");
        }
        if (claveCorrecta != null) {
            result.append("CLAVE CORRECTA: ").append(claveCorrecta).append("\n");
        }
        if (razonamiento != null) {
            result.append("RAZONAMIENTO: ").append(razonamiento);
        }
        
        return result.toString();
    }
}