/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorgrupos.grupos;

import java.util.HashMap;
import manejadorgrupos.usuario_modelo_simple.Alumno;

/**
 *
 * @author darkuser
 */
public class GestorGrupos {
    
    private final HashMap<Integer, Grupo> grupos = new HashMap<>();
    
    public void crearGrupo(int codigo, String nombre, int idProfesor) {
        grupos.put(codigo, new Grupo(codigo, nombre, idProfesor));
    }
    
    public void agregarAlumnoAlGrupo(int codigoGrupo, Alumno alumno) {
        alumno.setCodigoGrupo(codigoGrupo);
    }
    
    public String obtenerAvance(int codigo) {
        return grupos.get(codigo).obtenerEstadisticas();
    }

    public int obtenerCodigoPorNombre(String grupoSeleccionado) {
        int codigo = 0;
        for (Grupo i: grupos.values()) {
            if (i.getNombre().equals(grupoSeleccionado)) {
                codigo = i.getCodigo();
            }
        }
        return codigo;
    }

    public int obtenerCodigoUnico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
