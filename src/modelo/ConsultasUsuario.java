
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasUsuario extends Conexion {
    
    public boolean registrar(Usuario usu){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuario (nombre, apellido, dni, tipo_usuario, nombre_usuario, contrasenia) VALUES(?,?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setInt(3, usu.getDni());
            ps.setString(4, usu.getTipo_usuario());
            ps.setString(5, usu.getNombre_usuario());
            ps.setString(6, usu.getContrasenia());
            ps.execute();
            return true;
        } catch (SQLException e){
            
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
   
    public boolean modificar(Usuario usu){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE usuario SET nombre=?, apellido=?, dni=?, tipo_usuario=?, nombre_usuario=?, contrasenia=? WHERE id_usuario=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setInt(3, usu.getDni());
            ps.setString(4, usu.getTipo_usuario());
            ps.setString(5, usu.getNombre_usuario());
            ps.setString(6, usu.getContrasenia());
            ps.setInt(7, usu.getId());
            ps.execute();
            return true;
        } catch (SQLException e){
            
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
    
    public boolean eliminar(Usuario usu){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, usu.getId());
            ps.execute();
            return true;
        } catch (SQLException e){
            
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
    
    public boolean buscar(Usuario usu){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM usuario WHERE nombre=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                usu.setId(Integer.parseInt(rs.getString("id_usuario")));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setDni(Integer.parseInt(rs.getString("dni")));
                usu.setTipo_usuario(rs.getString("tipo_usuario"));
                usu.setNombre_usuario(rs.getString("nombre_usuario"));
                usu.setContrasenia(rs.getString("contrasenia"));
                return true;

            }
            return false;
        } catch (SQLException e){
            
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
    
    public boolean verificarUsuario(Usuario usu){
        
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Connection conexion = con.getConexion();
            
            ps = conexion.prepareStatement("SELECT id_usuario, nombre, apellido, dni, tipo_usuario, nombre_usuario, contrasenia FROM usuario WHERE nombre_usuario=?");
            ps.setString(1, usu.getNombre_usuario());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(usu.getContrasenia().equals(rs.getString("contrasenia"))){
                    usu.setId(rs.getInt("id_usuario"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setTipo_usuario(rs.getString("tipo_usuario"));
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        }catch(Exception e){
            return false;
        }
        
    }
}
