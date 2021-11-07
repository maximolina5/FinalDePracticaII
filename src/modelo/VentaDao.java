
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class VentaDao extends Conexion{
    
    PreparedStatement ps;
    Connection con = getConexion();
    int r;
    
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO venta (vendedor, total, fecha) VALUES(?,?,?)";
        try{
        ps = con.prepareStatement(sql);
        ps.setString(1, v.getVendedor());
        ps.setDouble(2, v.getTotal());
        ps.setString(3, v.getFecha());
        ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
            
        }
        return r;
    }
    
    public boolean ActualizarStock(int cant, String cod){
        
        String sql = "UPDATE producto SET cantidad=? WHERE codigo=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.print(e.toString());
            return false;
        }
    }
    
}
