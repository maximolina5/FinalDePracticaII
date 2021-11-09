
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
import modelo.UsuarioDao;
import modelo.Usuario;
import vistas.altaUsuario;


public class CtrlUsuario implements ActionListener{
    
    private Usuario mod;
    private UsuarioDao modC;
    private altaUsuario alt;

    public CtrlUsuario(Usuario mod, UsuarioDao modC, altaUsuario alt){
        
        this.mod = mod;
        this.modC = modC;
        this.alt = alt;
        this.alt.btnGuardar.addActionListener(this);
        this.alt.btnEliminar.addActionListener(this);
        this.alt.btnBorrar.addActionListener(this);
        this.alt.btnModificar.addActionListener(this);
  //      this.alt.btnBuscar.addActionListener(this);
     
    }
    
    public void iniciar(){
        
        alt.setTitle("Usuarios");
        alt.setLocationRelativeTo(null);
      //  alt.txtId.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == alt.btnGuardar){
            
            mod.setNombre(alt.txtNombre.getText());
            mod.setApellido(alt.txtApellido.getText());
            mod.setDni(Integer.parseInt(alt.txtDni.getText()));
            mod.setTipo_usuario(alt.txtTipoUsuario.getSelectedItem().toString());
            mod.setNombre_usuario(alt.txtNombreUsuario.getText());
            mod.setContrasenia(alt.txtContrasenia.getText());
            
            if(modC.registrar(mod)){                
                JOptionPane.showInternalMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al guardar");
                limpiar();
            }
            
        }
        
        if(e.getSource() == alt.btnModificar){
            mod.setId(Integer.parseInt(alt.txtId.getText()));
            mod.setNombre(alt.txtNombre.getText());
            mod.setApellido(alt.txtApellido.getText());
            mod.setDni(Integer.parseInt(alt.txtDni.getText()));
            mod.setTipo_usuario(alt.txtTipoUsuario.getSelectedItem().toString());
            mod.setNombre_usuario(alt.txtNombreUsuario.getText());
            mod.setContrasenia(alt.txtContrasenia.getText());
            
            if(modC.modificar(mod)){                
                JOptionPane.showInternalMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al modificar");
                limpiar();
            }
            
        }
        
        if(e.getSource() == alt.btnEliminar){
            
            mod.setId(Integer.parseInt(alt.txtId.getText()));          
            if(modC.eliminar(mod)){                
                JOptionPane.showInternalMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al eliminar");
                limpiar();
            }
            
        }
        
        if(e.getSource() == alt.btnBorrar){
            
            limpiar();
            
        }
        
    }
    
    
    public void limpiar(){
        
        alt.txtId.setText(null);
        alt.txtNombre.setText(null);
        alt.txtApellido.setText(null);
        alt.txtDni.setText(null);
        alt.txtTipoUsuario.setSelectedItem(null);
        alt.txtNombreUsuario.setText(null);
        alt.txtContrasenia.setText(null);
        
        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            alt.jtUsuario.setModel(modeloTabla);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT id_usuario, nombre, apellido, dni, tipo_usuario, nombre_usuario, contrasenia FROM usuario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modeloTabla.addColumn("id_usuario");
            modeloTabla.addColumn("nombre");
            modeloTabla.addColumn("apellido");
            modeloTabla.addColumn("dni");
            modeloTabla.addColumn("tipo_usuario");
            modeloTabla.addColumn("nombre_usuario");
            modeloTabla.addColumn("contrasenia");
            

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
