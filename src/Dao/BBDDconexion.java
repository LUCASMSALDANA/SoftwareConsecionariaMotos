
package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class BBDDconexion {
    Connection con;
    public Connection getConnection(){
        try{
            String BBDD = "jdbc:mysql://localhost:3306/consecionaria?serverTimezone=UTC";
            con = DriverManager.getConnection(BBDD,"root","root");
            return con;
         }catch(SQLException e){
             System.out.println(e.toString());
         }
         return null;
    }
}
