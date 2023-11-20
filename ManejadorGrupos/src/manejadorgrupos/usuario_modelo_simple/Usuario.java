/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorgrupos.usuario_modelo_simple;

/**
 *
 * @author darkuser
 */
public abstract class Usuario {
    
    static int codigoStatic = 0;
    
    private int codigoGrupo;
    private String nombre;
    private int codigo;

    public Usuario(String nombre) {
        codigoStatic++;
        this.nombre = nombre;
        this.codigo = codigoStatic;
    }

    /**
     * @return the codigoGrupo
     */
    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    /**
     * @param codigoGrupo the codigoGrupo to set
     */
    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
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
    
}
