package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProveedor extends Conexion {

    public boolean registrar(Proveedor pro) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO proveedor (nombre, compania, telefono) VALUES(?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getCompania());
            ps.setString(3, pro.getTelefono());
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

    public boolean modificar(Proveedor pro) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE proveedor SET nombre=?, compania=?, telefono=? WHERE id_proveedor=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getCompania());
            ps.setString(3, pro.getTelefono());
            ps.setInt(4, pro.getId());
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

    public boolean eliminar(Proveedor pro) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM proveedor WHERE id_proveedor=?";

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

    public boolean buscar(Proveedor pro) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM proveedor WHERE nombre=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id_proveedor")));
                pro.setNombre(rs.getString("nombre"));
                pro.setCompania(rs.getString("compania"));
                pro.setTelefono(rs.getString("telefono"));
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

}
