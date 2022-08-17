package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.cliente.Cliente;
/**
 *
 * @author Lucas
 */
public class ClienteDao {
    Connection con;
    BBDDconexion cn = new BBDDconexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cliente){
    String sql = "SELECT DNI FROM CLIENTES WHERE DNI = ?;";
    try{     
        con= cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,cliente.getDni());
        rs = ps.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"El DNI ingresado ya esta asociado a otro cliente", "DNI Duplicado",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        sql = "INSERT INTO CLIENTES(DNI,NOMBREAPELLIDO,TELEFONO,DIRECCION,CONDICIONFISCAL,RAZONSOCIAL) VALUES(?,?,?,?,?,?)" ;
        ps = con.prepareStatement(sql);
        ps.setString(1,cliente.getDni());
        ps.setString(2,cliente.getNombreApellido());
        ps.setString(3,cliente.getTelefono());
        ps.setString(4,cliente.getDireccion());
        ps.setString(5,cliente.getCondicionFiscal());
        ps.setString(6,cliente.getRazonSocial());
        ps.execute(); 
        return true;
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    }
    
    public boolean eliminarCliente(int id){
        String sql = "DELETE FROM CLIENTES WHERE IDCLIENTE  = ?;";
        try{
            int auto_increment=0;
             con = cn.getConnection();
             ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             ps.execute();
             sql = "SELECT MAX(IDCLIENTE) AS IDCLIENTE FROM CLIENTES";
             ps = con.prepareStatement(sql);
             rs=ps.executeQuery();                     
             while(rs.next()){auto_increment = (rs.getInt("IDCliente"));}
             sql="ALTER TABLE CLIENTES AUTO_INCREMENT =?;";
             ps = con.prepareStatement(sql);
             ps.setInt(1, auto_increment);
             ps.execute();
             return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.out.println(e.toString());
            }
        }
        
    } 
    
    public boolean actualizarCliente(Cliente cliente){
        String sql = "UPDATE CLIENTES SET DNI=?, NOMBREAPELLIDO =?, TELEFONO=?, DIRECCION=?, CONDICIONFISCAL=?,RAZONSOCIAL=? WHERE IDCLIENTE = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombreApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCondicionFiscal());
            ps.setString(6, cliente.getRazonSocial());
            ps.setInt(7,cliente.getIdcliente());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.out.println(e.toString());
            }
        }
        return false;
    }
    
    public List listarClientes(){
    List<Cliente> listaCliente = new ArrayList();
    String sql = "SELECT * FROM CLIENTES;";
    try{
        con = cn.getConnection();
        rs = con.prepareStatement(sql).executeQuery();  
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setIdcliente(rs.getInt("IDCliente"));
            cliente.setDni(rs.getString("DNI"));
            cliente.setNombreApellido(rs.getString("NOMBREAPELLIDO"));
            cliente.setTelefono(rs.getString("TELEFONO"));
            cliente.setDireccion(rs.getString("DIRECCION"));
            cliente.setCondicionFiscal(rs.getString("CONDICIONFISCAL"));
            cliente.setRazonSocial(rs.getString("RAZONSOCIAL"));
            listaCliente.add(cliente);
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    }
        return listaCliente;
    }
    
}
