/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorgrupos.grupos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author darkuser
 */
public class GestorGrupos {
    
    private final HashMap<Integer, Grupo> grupos = new HashMap<>();
    
    public void crearGrupo(String nombre, int idProfesor) {
        Grupo nuevoGrupo =  new Grupo(nombre, idProfesor);
        grupos.put(nuevoGrupo.getCodigo(), nuevoGrupo);
    }
    
    public Grupo obtenerGrupoPorCodigo(Integer codigoGrupo) {
        return grupos.get(codigoGrupo);
    }
    
    public String obtenerAvance(int codigo) {
        return grupos.get(codigo).obtenerEstadisticas();
    }

    public String obtenerAvanceTodoGrupos() {
        String msg = "";
        
        for (Grupo grupo: grupos.values()) {
            msg += grupo.obtenerEstadisticas();
        }
        return msg;
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
    
    public String obtenerInfoTodosGrupos() {
        String msg = "";
        
        for (Grupo grupo: grupos.values()) {
            msg += grupo.obtenerInfo();
        }
        return msg;
    }
    
    public HashMap<Integer, String> obtenerGruposIdNombre() {
        HashMap<Integer, String> hashForReturn = new HashMap<>();
        
        for (Map.Entry<Integer, Grupo> entry: grupos.entrySet()) {
            hashForReturn.put(entry.getKey(), entry.getValue().getNombre());
        }
        
        return hashForReturn;
    }
    
    public int obtenerCantidadGrupos() {
        return grupos.size();
    }
}
