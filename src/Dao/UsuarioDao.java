
package Dao;
import model.usuario.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.cliente.Cliente;

/**
 *
 * @author Lucas
 */
public class UsuarioDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    BBDDconexion cn = new BBDDconexion();
    
    public Usuario log(String nombre,String pass){
    Usuario user = new Usuario();
    String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ? AND PASS = ?";
    try{
        con=cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2,pass);
        rs= ps.executeQuery();
        if(rs.next()){
            user.setIdusuario(rs.getInt("idusuario"));
            user.setNombreapellido(rs.getString("nombre"));
            user.setPass(rs.getString("pass"));
            user.setAdmin(rs.getByte("admin")); 
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    }
    return user;
    }
    
   

}




