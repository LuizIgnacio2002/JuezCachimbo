package modelo;

public class Juez {
    private int contadorRespuestasCorrectas=0;
    private int contadorRespuestasIncorrectas=0;
    private int contadorRespuestasBlancas=0;
    private int numeroDePreguntas;
    //Actualizadores de contadores
    public int actualizarContadorRespuestasCorrectas(){
        return contadorRespuestasCorrectas++;
    }
    
    public int actualizarContadorRespuestasIncorrectas(){
        return contadorRespuestasIncorrectas++;
    }
    
    public int actualizarContadorRespuestasBlancas(){
        return contadorRespuestasBlancas++;
    }   
    
    //Getters and Setters
    public int getNumeroDePreguntas() {
        return numeroDePreguntas;
    }

    public void setNumeroDePreguntas(int numeroDePreguntas) {
        this.numeroDePreguntas = numeroDePreguntas;
    }
    
    
    public int getContadorRespuestasCorrectas() {
        return contadorRespuestasCorrectas;
    }

    public void setContadorRespuestasCorrectas(int contadorRespuestasCorrectas) {
        this.contadorRespuestasCorrectas = contadorRespuestasCorrectas;
    }

    public int getContadorRespuestasIncorrectas() {
        return contadorRespuestasIncorrectas;
    }

    public void setContadorRespuestasIncorrectas(int contadorRespuestasIncorrectas) {
        this.contadorRespuestasIncorrectas = contadorRespuestasIncorrectas;
    }

    public int getContadorRespuestasBlancas() {
        return contadorRespuestasBlancas;
    }

    public void setContadorRespuestasBlancas(int contadorRespuestasBlancas) {
        this.contadorRespuestasBlancas = contadorRespuestasBlancas;
    }

    
}
