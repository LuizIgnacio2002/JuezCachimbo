/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hellofx;

import java.util.ArrayList;

public class CEjercicio {
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<CPregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<CPregunta> preguntas) {
        this.preguntas = preguntas;
    }
    private String texto;
    private ArrayList<CPregunta> preguntas;
    
    public CEjercicio(String texto, ArrayList<CPregunta> preguntas){
        this.texto = texto;
        this.preguntas = preguntas;
    }
}