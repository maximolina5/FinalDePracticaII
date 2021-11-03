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
import modelo.ConsultasProductos;
import modelo.Producto;
import vistas.altaProductos;

public class CtrlProducto implements ActionListener {

    private Producto mod;
    private ConsultasProductos modC;
    private altaProductos frm;

    public CtrlProducto(Producto mod, ConsultasProductos modC, altaProductos frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.jLabel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setNombre(frm.txtNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setVencimiento(frm.txtVencimiento.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setFechaIngreso(frm.txtFechaIngreso.getText());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setVencimiento(frm.txtVencimiento.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setFechaIngreso(frm.txtFechaIngreso.getText());

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
            frm.txtId.setText("");
        }

        if (e.getSource() == frm.btnBorrar) {
            limpiar();

        }
    }

    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtNombre.setText(null);
        frm.txtDescripcion.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtFechaIngreso.setText(null);
        frm.txtVencimiento.setText(null);
        frm.txtCantidad.setText(null);
        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            frm.jtProductos.setModel(modeloTabla);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT nombre, cantidad, descripcion, fecha_vencimiento, precio, fecha_ingreso FROM producto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Vencimiento");
            modeloTabla.addColumn("Precio");
            modeloTabla.addColumn("Ingreso");

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
