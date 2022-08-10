
package model.usuario;

/**
 *
 * @author Lucas
 */
public class Usuario {
       private int idusuario;
    private String nombre;
    private String pass;
    private byte admin;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombre, String pass, byte admin) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.pass = pass;
        this.admin = admin;
    }
    
    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombreapellido(String nombreapellido) {
        this.nombre = nombreapellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public byte getAdmin() {
        return admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
    }

}
