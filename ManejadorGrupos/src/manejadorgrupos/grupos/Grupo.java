/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorgrupos.grupos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author darkuser
 */
public class Grupo {
    static int codigoGrupo = 0;
    
    private int codigo;
    private String nombre;
    private int idProfesor;

    private int cantidadTextosResueltos;
    private float porcentajePreguntasCorrectas;
    private float porcentajePromedioPreguntasCorrectas;
    private int textosMasLeidos;
    private int textosMasFaciles;
    private int textosMasDificiles;
    
    private List<Integer> codigoAlumnos;

    public Grupo(String nombre, int idProfesor) {
        codigoGrupo ++;
        this.codigo = codigoGrupo;
        this.nombre = nombre;
        this.idProfesor = idProfesor;
        
        codigoAlumnos = new LinkedList<>();
        
        // inicializar todas las estadisticas a 0
        cantidadTextosResueltos = 0;
        porcentajePreguntasCorrectas = 0f;
        porcentajePromedioPreguntasCorrectas = 0f;
        textosMasLeidos = 0;
        textosMasFaciles = 0;
        textosMasDificiles = 0;
    }
    
    public String obtenerInfo() {
        String msg = "";
        
        msg += "\n\tCódigo: " + codigo +
                "\n\tNombre: " + nombre + 
                "\n\tId profesor a cargo: " + idProfesor + "\n";
        
        return msg;
    }
    
    public String obtenerEstadisticas() {
        String msg = "";
        
        msg += "\n\tTextos Resueltos: " + cantidadTextosResueltos +
                "\n\tPorcentaje preguntas correctas: " + porcentajePreguntasCorrectas + 
                "\n\tPorcentaje promedio de preguntas correctas: " + porcentajePromedioPreguntasCorrectas + "\n";
        
        return msg;
    }
    
    public void aniadirAlumnosPorCodigo(int codigoAlumno) {
        codigoAlumnos.add(codigoAlumno);
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
