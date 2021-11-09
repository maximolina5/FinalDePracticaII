package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;



public class ProductoDao extends Conexion {

    DefaultTableModel modeloTabla;
    public boolean registrar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO producto (codigo, cantidad, descripcion, fecha_vencimiento, precio,  fecha_ingreso) VALUES(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setInt(2, pro.getCantidad());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getVencimiento());
            ps.setDouble(5, pro.getPrecio());
            ps.setString(6, pro.getFechaIngreso());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE producto SET codigo=?, cantidad=?, descripcion=?, fecha_vencimiento=?, precio=?,  fecha_ingreso=? WHERE id_producto=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setInt(2, pro.getCantidad());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getVencimiento());
            ps.setDouble(5, pro.getPrecio());
            ps.setString(6, pro.getFechaIngreso());
            ps.setInt(7, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM producto WHERE id_producto=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Producto pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM producto WHERE codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id_producto")));
                pro.setCodigo(Integer.parseInt(rs.getNString("codigo")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setVencimiento(rs.getString("fecha_vencimiento"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setFechaIngreso(rs.getString("fecha_ingreso"));
                return true;

            }
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public Producto BuscarPro(String cod){
        Producto producto = new Producto();
        String sql = "SELECT * FROM producto WHERE codigo=?";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        return producto;
    }
 

}