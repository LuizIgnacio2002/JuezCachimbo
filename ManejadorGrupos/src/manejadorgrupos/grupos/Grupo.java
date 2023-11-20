/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorgrupos.grupos;

/**
 *
 * @author darkuser
 */
public class Grupo {
    private int codigo;
    private String nombre;
    private int idProfesor;

    private int cantidadTextosResueltos;
    private float porcentajePreguntasCorrectas;
    private float porcentajePromedioPreguntasCorrectas;
    private int textosMasLeidos;
    private int textosMasFaciles;
    private int textosMasDificiles;

    public Grupo(int codigo, String nombre, int idProfesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idProfesor = idProfesor;
    }
    
    public String obtenerEstadisticas() {
        String msg = "";
        
        msg += "\n\tTextos Resueltos: " + cantidadTextosResueltos +
                "\n\tPorcentaje preguntas correctas: " + porcentajePreguntasCorrectas + 
                "\n\tPorcentaje promedio de preguntas correctas: " + porcentajePromedioPreguntasCorrectas;
        
        return msg;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idProfesor
     */
    public int getIdProfesor() {
        return idProfesor;
    }

    /**
     * @param idProfesor the idProfesor to set
     */
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    /**
     * @return the cantidadTextosResueltos
     */
    public int getCantidadTextosResueltos() {
        return cantidadTextosResueltos;
    }

    /**
     * @param cantidadTextosResueltos the cantidadTextosResueltos to set
     */
    public void setCantidadTextosResueltos(int cantidadTextosResueltos) {
        this.cantidadTextosResueltos = cantidadTextosResueltos;
    }

    /**
     * @return the porcentajePreguntasCorrectas
     */
    public float getPorcentajePreguntasCorrectas() {
        return porcentajePreguntasCorrectas;
    }

    /**
     * @param porcentajePreguntasCorrectas the porcentajePreguntasCorrectas to set
     */
    public void setPorcentajePreguntasCorrectas(float porcentajePreguntasCorrectas) {
        this.porcentajePreguntasCorrectas = porcentajePreguntasCorrectas;
    }

    /**
     * @return the porcentajePromedioPreguntasCorrectas
     */
    public float getPorcentajePromedioPreguntasCorrectas() {
        return porcentajePromedioPreguntasCorrectas;
    }

    /**
     * @param porcentajePromedioPreguntasCorrectas the porcentajePromedioPreguntasCorrectas to set
     */
    public void setPorcentajePromedioPreguntasCorrectas(float porcentajePromedioPreguntasCorrectas) {
        this.porcentajePromedioPreguntasCorrectas = porcentajePromedioPreguntasCorrectas;
    }

    /**
     * @return the textosMasLeidos
     */
    public int getTextosMasLeidos() {
        return textosMasLeidos;
    }

    /**
     * @param textosMasLeidos the textosMasLeidos to set
     */
    public void setTextosMasLeidos(int textosMasLeidos) {
        this.textosMasLeidos = textosMasLeidos;
    }

    /**
     * @return the textosMasFaciles
     */
    public int getTextosMasFaciles() {
        return textosMasFaciles;
    }

    /**
     * @param textosMasFaciles the textosMasFaciles to set
     */
    public void setTextosMasFaciles(int textosMasFaciles) {
        this.textosMasFaciles = textosMasFaciles;
    }

    /**
     * @return the textosMasDificiles
     */
    public int getTextosMasDificiles() {
        return textosMasDificiles;
    }

    /**
     * @param textosMasDificiles the textosMasDificiles to set
     */
    public void setTextosMasDificiles(int textosMasDificiles) {
        this.textosMasDificiles = textosMasDificiles;
    }
    
}
