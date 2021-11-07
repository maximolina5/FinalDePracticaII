package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.ProveedorDao;
import modelo.Proveedor;
import vistas.altaProveedores;

public class CtrlProveedor implements ActionListener {

    private Proveedor mod;
    private ProveedorDao modC;
    private altaProveedores alt;

    public CtrlProveedor(Proveedor mod, ProveedorDao modC, altaProveedores alt) {

        this.mod = mod;
        this.modC = modC;
        this.alt = alt;
        this.alt.btnGuardar.addActionListener(this);
        this.alt.btnEliminar.addActionListener(this);
        this.alt.btnBorrar.addActionListener(this);
        this.alt.btnModificar.addActionListener(this);
        this.alt.btnBuscar.addActionListener(this);

    }

    public void iniciar() {

        alt.setTitle("Proveedores");
        alt.setLocationRelativeTo(null);
        alt.txtId.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == alt.btnGuardar) {

            mod.setNombre(alt.txtNombre.getText());
            mod.setCompania(alt.txtCompania.getText());
            mod.setTelefono(alt.txtTelefono.getText());

            if (modC.registrar(mod)) {
                JOptionPane.showInternalMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al guardar");
                limpiar();
            }

        }
        if (e.getSource() == alt.btnModificar) {

            mod.setId(Integer.parseInt(alt.txtId.getText()));
            mod.setNombre(alt.txtNombre.getText());
            mod.setCompania(alt.txtCompania.getText());
            mod.setTelefono(alt.txtTelefono.getText());

            if (modC.modificar(mod)) {
                JOptionPane.showInternalMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al modificar");
                limpiar();
            }

        }
        if (e.getSource() == alt.btnEliminar) {

            mod.setId(Integer.parseInt(alt.txtId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showInternalMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al eliminar");
                limpiar();
            }

        }
        if (e.getSource() == alt.btnBuscar) {

            mod.setNombre(alt.txtNombre.getText());

            if (modC.buscar(mod)) {
                alt.txtId.setText(String.valueOf(mod.getId()));
                alt.txtNombre.setText(mod.getNombre());
                alt.txtCompania.setText(mod.getCompania());
                alt.txtTelefono.setText(mod.getTelefono());

            } else {
                JOptionPane.showInternalMessageDialog(null, "No se encontro registro");
                limpiar();
            }

        }

        if (e.getSource() == alt.btnBorrar) {

            limpiar();

        }

    }

    public void limpiar() {

        alt.txtId.setText(null);
        alt.txtNombre.setText(null);
        alt.txtCompania.setText(null);
        alt.txtTelefono.setText(null);

        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            alt.jtProveedores.setModel(modeloTabla);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT nombre, compania, telefono FROM proveedor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modeloTabla.addColumn("nombre");
            modeloTabla.addColumn("compania");
            modeloTabla.addColumn("telefono");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);

                }
                modeloTabla.addRow(filas);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

}
