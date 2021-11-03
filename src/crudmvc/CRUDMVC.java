package crudmvc;

import controlador.CtrlProducto;
import controlador.CtrlUsuario;
import modelo.ConsultasProductos;
import modelo.ConsultasUsuario;
import modelo.Producto;
import modelo.Usuario;
import vistas.altaProductos;
import vistas.altaUsuario;

public class CRUDMVC {
    
    public static void main (String [] args){
        
//        Producto mod= new Producto();
//        ConsultasProductos modC = new ConsultasProductos();
//        altaProductos frm = new altaProductos();
//        
//        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
//        ctrl.iniciar();
//        frm.setVisible(true);
        
        Usuario mod = new Usuario();
        ConsultasUsuario modC = new ConsultasUsuario();
        altaUsuario alt = new altaUsuario();
        
        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, alt);
        ctrl.iniciar();
        alt.setVisible(true);        
    }
    
}
