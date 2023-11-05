package hellofx;
import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String contraseña;
    private String nombreUsuario;
    private int puntuacion;
    
    public Usuario(String nombre, String contraseña, String nombreUsuario){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
        puntuacion = 0;
    }

    public String toUTF8String() {
        return "Username: " + nombreUsuario + "\nPassword: " + contraseña + "\nNombres: " + nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void colocarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerContraseña() {
        return contraseña;
    }

    public void colocarContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String obtenerNombreUsuario() {
        return nombreUsuario;
    }

    public void colocarNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int obtenerPuntuacion() {
        return puntuacion;
    }

    public void colocarPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}

