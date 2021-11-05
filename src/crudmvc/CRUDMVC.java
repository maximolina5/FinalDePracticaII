package crudmvc;

import controlador.CtrlProducto;
import controlador.CtrlProveedor;
import controlador.CtrlUsuario;
import modelo.ConsultasProductos;
import modelo.ConsultasProveedor;
import modelo.ConsultasUsuario;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Usuario;
import vistas.altaProductos;
import vistas.altaProveedores;
import vistas.altaUsuario;

public class CRUDMVC {

    public static void main(String[] args) {

//        Producto mod= new Producto();
//        ConsultasProductos modC = new ConsultasProductos();
//        altaProductos frm = new altaProductos();
//        
//        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
//        ctrl.iniciar();
//        frm.setVisible(true);


//        Usuario mod = new Usuario();
//        ConsultasUsuario modC = new ConsultasUsuario();
//        altaUsuario alt = new altaUsuario();
//        
//        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, alt);
//        ctrl.iniciar();
//        alt.setVisible(true); 


        Proveedor mod = new Proveedor();
        ConsultasProveedor modC = new ConsultasProveedor();
        altaProveedores alt = new altaProveedores();

        CtrlProveedor ctrl = new CtrlProveedor(mod, modC, alt);
        ctrl.iniciar();
        alt.setVisible(true);
    }

}
