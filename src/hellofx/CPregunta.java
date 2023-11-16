/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hellofx;

import java.util.ArrayList;

public class CPregunta {
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public ArrayList<CAlternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<CAlternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getRazonamiento() {
        return razonamiento;
    }
    
    private String pregunta;
    private int respuesta;
    private ArrayList<CAlternativa> alternativas;
    private String razonamiento;
    
    public CPregunta(String pregunta, int respuesta, ArrayList<CAlternativa> alternativas, String razonamiento){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.alternativas = alternativas;
        this.razonamiento = razonamiento;
    }
}
