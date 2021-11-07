package crudmvc;

import controlador.CtrlProducto;
import controlador.CtrlProveedor;
import controlador.CtrlUsuario;
import modelo.ProductoDao;
import modelo.ProveedorDao;
import modelo.UsuarioDao;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Usuario;
import vistas.altaProductos;
import vistas.altaProveedores;
import vistas.altaUsuario;

public class CRUDMVC {

    public static void main(String[] args) {

        Producto mod= new Producto();
        ProductoDao modC = new ProductoDao();
        altaProductos frm = new altaProductos();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);


//        Usuario mod = new Usuario();
//        UsuarioDao modC = new UsuarioDao();
//        altaUsuario alt = new altaUsuario();
//        
//        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, alt);
//        ctrl.iniciar();
//        alt.setVisible(true); 


//        Proveedor mod = new Proveedor();
//        ProveedorDao modC = new ProveedorDao();
//        altaProveedores alt = new altaProveedores();
//
//        CtrlProveedor ctrl = new CtrlProveedor(mod, modC, alt);
//        ctrl.iniciar();
//        alt.setVisible(true);
    }

}
