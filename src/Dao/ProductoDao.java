package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.producto.Producto;

/**
 *
 * @author Lucas
 */
public class ProductoDao {
    Connection con;
    BBDDconexion cn = new BBDDconexion();
    PreparedStatement ps;
    ResultSet rs;

 public List listarProductos(){
    List<Producto> listaProducto = new ArrayList();
    String sql = "SELECT * FROM PRODUCTOS;";
    try{
        con = cn.getConnection();
        rs = con.prepareStatement(sql).executeQuery();  
        while(rs.next()){
            Producto producto = new Producto();
            producto.setIdproducto(rs.getInt("IDPRODUCTO"));
            producto.setDescripcion(rs.getString("DESCRIPCION"));
            producto.setAnio(rs.getInt("ANIO"));
            producto.setStock(rs.getInt("STOCK"));
            producto.setPrecio(rs.getFloat("PRECIO"));
            producto.setColor(rs.getString("COLOR"));
            listaProducto.add(producto);
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    }
        return listaProducto;
    }

 public boolean registrarProducto(Producto producto){
     String sql = "SELECT * FROM PRODUCTOS WHERE DESCRIPCION=? AND ANIO=? AND COLOR= ? ;";
     try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, producto.getDescripcion());
         ps.setInt(2, producto.getAnio());
         ps.setString(3, producto.getColor());
         rs = ps.executeQuery();
         if(rs.next()){
            JOptionPane.showMessageDialog(null,"Producto repetido. Verifique: \n\tDescripción.\n\tAño.\n\tColor.", "Producto Duplicado",JOptionPane.ERROR_MESSAGE);
            return false;
         }
         sql = "INSERT INTO PRODUCTOS(DESCRIPCION,ANIO,STOCK,PRECIO,COLOR) VALUES (?,?,?,?,?);";
         ps = con.prepareStatement(sql);
         ps.setString(1,producto.getDescripcion());
         ps.setInt(2,producto.getAnio());
         ps.setInt(3,producto.getStock());
         ps.setFloat(4,producto.getPrecio());
         ps.setString(5,producto.getColor());
         ps.execute();
         return true;
     }catch(SQLException e){
         e.toString();
         return false;
     }finally{
         try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
     }
 }

 public boolean eliminarProducto(int id){
     String sql = "DELETE FROM PRODUCTOS WHERE IDPRODUCTO=?;" ;
     try{
        int auto_increment=0;
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        sql = "SELECT MAX(IDPRODUCTO) AS IDPRODUCTO FROM CLIENTES";
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();                     
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

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE PRODUCTOS SET DESCRIPCION=?, ANIO=?, STOCK=?, PRECIO=?, COLOR=? WHERE IDPRODUCTO = ?";
        try{
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2,producto.getAnio());
            ps.setInt(3,producto.getStock());
            ps.setFloat(4,producto.getPrecio());
            ps.setString(5,producto.getColor());
            ps.setInt(6, producto.getIdproducto());
            ps.execute();            
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
}

